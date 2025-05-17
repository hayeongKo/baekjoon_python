import java.util.*;

class Solution {
    static boolean[][] visited;
    static int N, M;
    
    class Point {
        int x, y, d;
        Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        return bfs(maps);
    }
    
    public int bfs(int[][] maps) {
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0, 0, 1));
        visited[0][0] = true;
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            if (now.x == N-1 && now.y == M-1) return now.d;
            
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny] || maps[nx][ny] == 0) continue;
                
                visited[nx][ny] = true;
                queue.offer(new Point(nx, ny, now.d+1));
            }
        }
        
        return -1;
    }
}