import java.util.*;

class Solution {
    int N, M;
    boolean[][] visited;
    int[][] land;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int[] ans;
    
    public int solution(int[][] land) {
        this.N = land.length;
        this.M = land[0].length;
        this.land = land;
        visited = new boolean[N][M];
        int id = 2;
        ans = new int[M];
        
        // 땅따먹기
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    bfs(i, j, id);
                    id++;
                }
            }
        }
        
        // 조사시작
        int answer = 0;
        for(int i = 0; i < M; i++) answer = Math.max(answer, ans[i]);
        return answer;
        
    }
    
    public int bfs(int x, int y, int id) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});
        land[x][y] = id;
        int ex = 1;
        boolean[] visitedY = new boolean[M];
        visitedY[y] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                
                if (inRange(nx, ny) && !visited[nx][ny] && land[nx][ny] == 1) {
                    visitedY[ny] = true;
                    visited[nx][ny] = true;
                    land[nx][ny] = id;
                    ex++;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        // System.out.println(Arrays.toString(visitedY) + " " + ex + " " + id);
        for(int i = 0; i < M; i++) {
            if (visitedY[i]) ans[i]+=ex;
        }
        
        return ex;
        
    }
    
    public boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}