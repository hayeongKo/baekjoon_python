import java.util.*;

class Solution {
    int N, M;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new int[]{0, 0, 1}); // x y d
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            
            if (x == N-1 && y == M-1) {
                return d;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if (inRange(nx, ny) && !visited[nx][ny] && maps[nx][ny]!=0) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, d+1});
                }
                
            }
        }
        
        return -1;
    }
    
    public boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}