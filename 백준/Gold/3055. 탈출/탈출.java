import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[][] map;
    static Point dest, start;
    static ArrayDeque<Point> water;
    static boolean[][] visited;
    static int res;

    static class Point {
        int x, y, d;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        R = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);
        map = new int[R][C];
        visited = new boolean[R][C];
        res = Integer.MAX_VALUE;
        water = new ArrayDeque<>();
        
        for(int i = 0; i < R; i++) {
            inputs = br.readLine().split("");
            for(int j = 0; j < C; j++) {
                if (inputs[j].equals("D")) {
                    dest = new Point(i, j);
                    map[i][j] = -1;
                } else if (inputs[j].equals("S")) {
                    start = new Point(i, j);
                    map[i][j] = -1;
                } else if (inputs[j].equals("*")) {
                    water.offer(new Point(i, j));
                    map[i][j] = 1;
                } else if (inputs[j].equals("X")) {
                    map[i][j] = 2;
                }
            }
        }

        bfs(start);
    }

    public static void bfs(Point start) {
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(start.x, start.y, 0));
        visited[start.x][start.y] = true;

        List<Point> next;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int nx, ny;
        
        while(!queue.isEmpty()) {
            
            // 물 번짐
            int size = water.size();
            for(int k = 0; k < size; k++) {
                Point w = water.pop();
                for(int i = 0; i < 4; i++) {
                    nx = w.x + dx[i];
                    ny = w.y + dy[i];
                    if (0 <= nx && nx < R && 0 <= ny && ny < C && map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        water.offer(new Point(nx, ny));
                    }
                }
            }

            next = new ArrayList<>();
            while (!queue.isEmpty()) {
                //고슴이 이동
                Point now = queue.pop();
                // D 도착 시
                if (now.x == dest.x && now.y == dest.y) {
                    res = Math.min(res, now.d);
                }

                for(int i = 0; i < 4; i++) {
                    nx = now.x + dx[i];
                    ny = now.y + dy[i];
                    if (0 <= nx && nx < R && 0 <= ny && ny < C && !visited[nx][ny] && map[nx][ny] != 1 && map[nx][ny] != 2) {
                        visited[nx][ny] = true;
                        next.add(new Point(nx, ny, now.d+1));
                    }
                }
            }
            queue.addAll(next);

        }

        if (res == Integer.MAX_VALUE) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(res);
        }
    }
}