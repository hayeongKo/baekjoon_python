import java.util.*;
import java.io.*;

public class Main {
    static int T, M, N, K;
    static int[][] field;
    static boolean[][] visited;
    static class Point{
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String[] inputs = br.readLine().split(" ");
            M = Integer.parseInt(inputs[0]);
            N = Integer.parseInt(inputs[1]);
            K = Integer.parseInt(inputs[2]);

            field = new int[N][M];
            visited = new boolean[N][M];
            for(int i = 0; i < K; i++) {
                inputs = br.readLine().split(" ");
                field[Integer.parseInt(inputs[1])][Integer.parseInt(inputs[0])] = 1;
            }

            int answer = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(!visited[i][j] && field[i][j] == 1) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public static void bfs(int x, int y) {
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while(!queue.isEmpty()) {
            Point now = queue.pop();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && field[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }
}