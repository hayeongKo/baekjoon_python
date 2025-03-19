import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int r, c, d;
    static int[][] map; // 0: 청소 필요 1: 벽 -1: 청소 완료 (방문 완료)
    static int clean; 
    static class Point {
        int x, y, d;
        Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        map = new int[N][M];
        clean = 0;
        
        inputs = br.readLine().split(" ");
        r = Integer.parseInt(inputs[0]);
        c = Integer.parseInt(inputs[1]);
        d = Integer.parseInt(inputs[2]);

        for(int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        bfs(r, c, d);
        System.out.println(clean);
    }

    public static void bfs(int x, int y, int d) {
        ArrayDeque<Point> queue = new ArrayDeque<>();
        int[] dx = {-1, 0, 1, 0}; // 남 동 북 서
        int[] dy = {0, 1, 0, -1};

        queue.offer(new Point(x, y, d));

        while(!queue.isEmpty()) {
            Point now = queue.pop();

            if (map[now.x][now.y] == 0) {
                map[now.x][now.y] = -1; // 청소
                clean++;
            }
            boolean cleanable = false;

            for(int i = 0; i < 4; i++) { // 청소 가능 칸이 있는지 확인
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0) cleanable = true;
                }
            }

            // 만약 청소할 칸이 없다면
            if (!cleanable) { // 후진 처리
                int mx = now.x + dx[(now.d + 2) % 4];
                int my = now.y + dy[(now.d + 2) % 4];

                if (map[mx][my] == 1) return; // 뒤가 벽이면 종료
                queue.offer(new Point(mx, my, now.d));
            } else {
                Point next = turn(now.d, now.x, now.y);
                queue.offer(next);
                // if (next.x != now.x || next.y != now.y) { 
                //     queue.offer(next);
                // }
            }
        }
    }

    public static Point turn(int d, int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4; // 반시계 방향 회전
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                return new Point(nx, ny, d);
            }
        }
        return new Point(x, y, d); // 네 방향 모두 청소가 불가능하면 제자리 유지
    }
}