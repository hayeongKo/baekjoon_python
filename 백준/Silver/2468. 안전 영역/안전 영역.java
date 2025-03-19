import java.util.*;
import java.io.*;

// 23 + 
public class Main {
    static int N, low, high;
    static int[][] region;
    static boolean[][] visited;
    static int ans;
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = Integer.MIN_VALUE;
        low = Integer.MAX_VALUE;
        high = Integer.MIN_VALUE;
        region = new int[N][N];
        visited = new boolean[N][N];

        int res = 0;

        String[] inputs;
        for(int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                int k = Integer.parseInt(inputs[j]);
                low = Math.min(low, k);
                high = Math.max(high, k);
                region[i][j] = k;
            }
        }

        if (low == high) {
            System.out.println(1);
            return;
        }

        for(int h = low; h <= high; h++) {
            res = 0;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if (!visited[i][j] && region[i][j] > h) {
                        res++;
                        bfs(i, j, h);
                    }
                }
            }
            ans = Math.max(ans, res);
        }

        System.out.println(ans);
    }

    public static void bfs(int x, int y, int h) {
        ArrayDeque<Point> queue = new ArrayDeque<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        visited[x][y] = true;
        queue.offer(new Point(x, y));

        while(!queue.isEmpty()) {
            Point now = queue.pop();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && region[nx][ny] > h) {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }

    }
}