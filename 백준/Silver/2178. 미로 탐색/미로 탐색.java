import java.util.*;
import java.io.*;

class Point {
    int x,y,d;
    Point(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Main {
    static int N, M;
    static int[][] miro;
    static boolean[][] visited;
    static int min;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        miro = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        min = 0;

        for(int i = 1; i <= N; i++) {
            inputs = br.readLine().split("");
            for(int j = 1; j <= M; j++) {
                miro[i][j] = Integer.parseInt(inputs[j-1]);
            }
        }
        bfs(1, 1);
        System.out.println(min);
    }

    public static void bfs(int x, int y) {
        ArrayDeque<Point> queue = new ArrayDeque<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        visited[x][y] = true;
        queue.offer(new Point(x, y, 1));

        while(!queue.isEmpty()) {
            Point now = queue.pop();

            if (now.x == N && now.y == M) {
                // min = Math.min(min, now.d);
                min = now.d;
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
                    if (miro[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny, now.d+1));
                    }
                }
            }
        }
    }
}