import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map, dist;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 0;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            map = new int[N][N];

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra();
            System.out.println("Problem " + ++t + ": " + dist[N-1][N-1]);
        }
        


    }

    public static void dijkstra() {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        boolean[][] visited = new boolean[N][N];
        dist = new int[N][N];

        for(int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
        }

        dist[0][0] = map[0][0];
        q.offer(new int[]{0, 0, dist[0][0]});

        while(!q.isEmpty()) {
            int[] u = q.poll();
            int ux = u[0];
            int uy = u[1];
            int cost = u[2];
            if (ux == N-1 && uy == N-1) break;

            if (visited[ux][uy]) continue;
            visited[ux][uy] = true;

            for(int d = 0; d < 4; d++) {
                int nx = ux+dx[d];
                int ny = uy+dy[d];
                if (inRange(nx, ny) && !visited[nx][ny] && dist[nx][ny] > cost+map[nx][ny]) {
                    dist[nx][ny] = cost+map[nx][ny];
                    q.offer(new int[]{nx, ny, cost+map[nx][ny]});
                }
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
