
// 18513
// 샘터

import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static Set<Integer> springs = new HashSet<>();
    static long misfortune = 0;
    static Set<Long> visited = new HashSet<>();
    static ArrayDeque<Map<Long, Long>> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] buffer = br.readLine().split(" ");
        N = Integer.parseInt(buffer[0]);
        K = Integer.parseInt(buffer[1]);

        buffer = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(buffer[i]);
            springs.add(x);
            Map<Long, Long> temp = new HashMap<>();
            temp.put(Long.valueOf(x), 0L);
            queue.add(temp);
            visited.add(Long.valueOf(x));
        }
    
        bfs();
    }

    public static void bfs() {
        // 방향벡터
        int[] dx = {-1, 1};

        while(!queue.isEmpty()) {
            Map<Long, Long> temp = queue.poll();
            long pos = temp.keySet().iterator().next();
            long dist = temp.get(pos);

            for(int i = 0; i < 2; i++) {
                if (!visited.contains(pos+dx[i])) {
                    visited.add(pos+dx[i]);
                    misfortune += dist+1;
                    Map<Long, Long> current = new HashMap<>();
                    current.put(pos+dx[i], dist+1);
                    queue.offer(current);
                    K--;
                    if (K==0) {
                        System.out.println(misfortune);
                        return;
                    }
                }
            }
        }
    }
}