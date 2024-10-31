// 16234
// 인구 이동

import java.util.*;
import java.io.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[][] prev;

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        L = Integer.parseInt(inputs[1]);
        R = Integer.parseInt(inputs[2]);


        //초기화
        map = new int[N][N];
        prev = new int[N][N];
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
                prev[i][j] = map[i][j];
            }
        }
        
        int day = 0;

        while(true) {
            visited = new boolean[N][N]; // 방문 초기화

            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        bfs(i,j);
                    }
                }
            }

            if (!moved()) {
                break;
            }

            day++;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    prev[i][j] = map[i][j];
                }
            }
            
        }
        System.out.println(day);
    }

    public static void bfs(int x, int y) {
        ArrayDeque<Point> q = new ArrayDeque<>();
        List<Point> union = new ArrayList<>();

        q.add(new Point(x, y));
        union.add(new Point(x, y));

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= N || nx < 0 || ny >= N || ny < 0) {
                    continue;
                }

                if(L <= Math.abs(map[nx][ny]-map[p.x][p.y]) && Math.abs(map[nx][ny]-map[p.x][p.y]) <= R && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                    union.add(new Point(nx, ny));
                }
            }
        }

        // 인구 이동
        move(union);
    }

    public static void move(List<Point> union) {
        int sum = 0;

        for(Point point : union) {
            sum += map[point.x][point.y];
        }

        int people = sum/union.size();

        for(Point point : union) {
            map[point.x][point.y] = people;
        }
    }

    public static boolean moved() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != prev[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}