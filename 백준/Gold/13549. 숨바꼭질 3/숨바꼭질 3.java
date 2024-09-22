// 13549
// 숨바꼭질 3

import java.io.*;
import java.util.ArrayDeque;

public class Main {
    static int X, K;
    static ArrayDeque<Integer> q = new ArrayDeque<>();
    static int[] map = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        X = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);
    
        // 초기화
        for(int i = 0; i < map.length; i++) {
            map[i] = -1;
        }

        bfs(0, X);
    }

    public static void bfs(int t, int x) {
        q.offer(x);
        map[x] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            
            if (now == K) {
                System.out.println(map[K]);
                return;
            }

            if (now*2 < 1000001 && map[now*2] == -1) {
                q.offerFirst(now*2);
                map[now*2] = map[now];
            }

            if (now-1 > -1 && map[now-1] == -1) {
                q.offerLast(now-1);
                map[now-1] = map[now]+1;
            }

            if (now+1 < 1000001 && map[now+1] == -1) {
                q.offerLast(now+1);
                map[now+1] = map[now]+1;
            }
        }
    }
}