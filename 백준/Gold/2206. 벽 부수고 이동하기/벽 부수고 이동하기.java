import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] map;
    static class Point {
        int x, y, d, broken;
        Point(int x, int y, int d, int broken) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.broken = broken;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        map = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            inputs = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        
        System.out.println(bfs());
    }
    
    public static int bfs() {
        ArrayDeque<Point> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2];
        queue.offer(new Point(0, 0, 1, 0));
        visited[0][0][0] = true;
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            if (now.x == N-1 && now.y == M-1) return now.d;
            
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (map[nx][ny] == 0 && !visited[nx][ny][now.broken]) {
                        visited[nx][ny][now.broken] = true;
                        queue.offer(new Point(nx, ny, now.d+1, now.broken));
                    }
                    
                    if (map[nx][ny] == 1 && now.broken == 0 && !visited[nx][ny][now.broken]) {
                        visited[nx][ny][1] = true;
                        queue.offer(new Point(nx, ny, now.d+1, 1));
                    }
                }
            }
        }
        return -1;
    }
}