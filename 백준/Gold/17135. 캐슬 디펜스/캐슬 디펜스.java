import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int N, M, D;
    static int[] dx = {0, -1, 0};
    static int[] dy = {-1, 0, 1};
    static int ans;
    static int[][] original;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        ans = 0;
        map = new int[N][M];
        original = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                original[i][j] = map[i][j];
            }
        }
        
        // List<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(4);
        dfs(new ArrayList<>(), 0);
        System.out.println(ans);
        // System.out.println(play(list));
    }


    // 궁수 위치 정하기
    public static void dfs(List<Integer> pos, int start) {
        if (pos.size() == 3) {
            int res = play(pos);
            ans = Math.max(res, ans);
            return;
        }

        for(int i = start; i < M; i++) {
            pos.add(i);
            dfs(pos, i+1);
            pos.remove(pos.size()-1);
        }
    }

    public static int play(List<Integer> pos) {
        int res = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = original[i][j];
            }
        }

        // 게임 진행
        for(int round = 1; round <= N; round++) {
            // System.out.println("round: " + round);
            // 궁수 공격
            Set<String> tmp = new HashSet<>();
            for(int p : pos) {
                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{N+1-round, p, 0});
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];

                    String np = x+" "+y;
                    if (inRange(x, y) && map[x][y] == 1 && x < N+1-round) {
                        // System.out.println(np);
                        tmp.add(np);
                        break;
                    }

                    int d = cur[2];
                    if (d == D) continue;
                    for(int i = 0; i < 3; i++) {
                        int nx = x+dx[i];
                        int ny = y+dy[i];
                        if (inRange(nx, ny) && nx <= N+1-round) q.offer(new int[]{nx, ny, d+1});
                    }
                }
            }
            for(String pp : tmp) {
                String[] s = pp.split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                map[x][y] = 0;
                res++;
            }
        }
        
        return res;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}