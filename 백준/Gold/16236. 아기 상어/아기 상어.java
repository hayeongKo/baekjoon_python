// 16236
// 아기 상어 뚜루룻뚜루

import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dis;
    static int size;
    static int res;
    static int eaten;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        size = 2;
        int x = 0;
        int y = 0;
        res = 0;
        eaten = 0;

        visited = new boolean[N][N];
        map = new int[N][N];
        dis = new int[N][N];

        String[] inputs;
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
                if (map[i][j] == 9) {
                    x = i;
                    y = j;
                    map[i][j] = 0; // 아기 상어 있던 곳도 빈 칸으로 초기화
                }
            }
        }

        solution(x, y);
        System.out.println(res);
    }

    public static void solution(int x, int y) {
        Point current = new Point(x, y);

        while(true) {
            Point dest = findCloseFish(current);
            
            if (dest == null) {
                break; // 더 이상 먹을 수 있는 물고기가 없을 경우
            }

            int dist = bfs(current, dest);

            if (dist == -1) {
                break; // 갈 수 있는 경로가 없을 경우
            }

            res += dist;
            current = dest;
            map[current.x][current.y] = 0; // 물고기 먹음
            eaten++;
            
            if (size == eaten) {
                size++;
                eaten = 0;
            }
            
        }
    }

    public static int bfs(Point current, Point dest) {
        ArrayDeque<Point> q = new ArrayDeque<>();

        // 초기화
        visited = new boolean[N][N];
        dis = new int[N][N];

        q.offer(current);
        visited[current.x][current.y] = true;

        while (!q.isEmpty()) {
            current = q.poll();
            int x = current.x;
            int y = current.y;

            if (x == dest.x && y == dest.y) {
                return dis[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (visited[nx][ny] || map[nx][ny] > size) {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new Point(nx, ny));
                dis[nx][ny] = dis[x][y] + 1;
            }
        }

        return -1;
    }

    public static Point findCloseFish(Point current) {
        ArrayDeque<Point> q = new ArrayDeque<>();
        int minDist = Integer.MAX_VALUE;
        visited = new boolean[N][N];
        dis = new int[N][N];

        q.offer(current);
        visited[current.x][current.y] = true;
        List<Point> edibleFishes = new ArrayList<>();

        while (!q.isEmpty()) {
            current = q.poll();
            int x = current.x;
            int y = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (visited[nx][ny] || map[nx][ny] > size) {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new Point(nx, ny));
                dis[nx][ny] = dis[x][y] + 1;

                if (map[nx][ny] != 0 && map[nx][ny] < size) {

                    if (minDist > dis[nx][ny]) {
                        minDist = dis[nx][ny];
                        edibleFishes.clear();
                        edibleFishes.add(new Point(nx, ny));
                    } else if (minDist == dis[nx][ny]) {
                        edibleFishes.add(new Point(nx, ny));
                    }
                } 
            }
        }

        if (edibleFishes.size() == 0) {
            return null;
        }

        Collections.sort(edibleFishes, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.x == p2.x) {
                    // x좌표가 같으면 y좌표로 비교
                    return Integer.compare(p1.y, p2.y);
                } else {
                    // x좌표로 비교
                    return Integer.compare(p1.x, p2.x);
                }
            }
        });
        return edibleFishes.get(0);
    }
}
