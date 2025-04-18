import java.io.*;
import java.util.*;

// 적록색약
public class Main {
    static int N;
    static String[][] grid;
    static boolean[][] visited1, visited2;
    static int a1, a2;
    static class Point{
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new String[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];
        
        for(int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                grid[i][j] = inputs[j];
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (!visited1[i][j]) bfs(i, j);
                if (!visited2[i][j]) bfsFora2(i, j);
            }
        }

        System.out.println(a1 + " " + a2);
    }

    public static void bfs(int x, int y) {
        a1++;
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x, y));
        visited1[x][y] = true;
        String c = grid[x][y];

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while(!queue.isEmpty()) {
            Point now = queue.pop();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited1[nx][ny] && grid[nx][ny].equals(c)) {
                    visited1[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void bfsFora2(int x, int y) {
        a2++;
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x, y));
        visited2[x][y] = true;
        StringBuilder sb = new StringBuilder(grid[x][y]);
    
        if (sb.toString().equals("R")) {
            sb.append("G");
        } else if (sb.toString().equals("G")) {
            sb.append("R");
        }

        String c = sb.toString();

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while(!queue.isEmpty()) {
            Point now = queue.pop();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited2[nx][ny] && c.contains(grid[nx][ny])) {
                    visited2[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }
}