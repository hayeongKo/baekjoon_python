import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int N, M;
    public int solution(String[] storage, String[] requests) {
        char[][] storages = new char[storage.length+2][storage[0].length()+2];
        N = storage.length+2;
        M = storage[0].length()+2;
        
        for(int i = 0; i < N; i++) {
            Arrays.fill(storages[i], ' ');
        }
        
        for(int i = 1; i <= storage.length; i++) {
            for(int j = 1; j <= storage[0].length(); j++) {
                storages[i][j] = storage[i-1].charAt(j-1);
            }
        }
        
        for(String r : requests) {
            char c = r.charAt(0);
            switch(r.length()) {
                case 1:
                    List<int[]> removable = new ArrayList<>();
                    boolean[][] visited = new boolean[N][M];
                    Queue<int[]> q = new ArrayDeque<>();
                    
                    q.offer(new int[]{0, 0});
                    visited[0][0] = true;
                    
                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0];
                        int y = cur[1];
                        
                        for(int i = 0; i < 4; i++) {
                            int nx = x+dx[i];
                            int ny = y+dy[i];
                            
                            if (inRange(nx, ny) && !visited[nx][ny]) {
                                if (storages[nx][ny] == c) removable.add(new int[]{nx, ny});
                                if (storages[nx][ny] == ' ') q.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    
                    for(int[] p : removable) {
                        storages[p[0]][p[1]] = ' ';
                    }
                    break;
                case 2:
                    for(int i = 1; i < N-1; i++) {
                        for(int j = 1; j < M-1; j++) {
                            if (storages[i][j] == c) storages[i][j] = ' ';
                        }
                    }
                    break;
            }
            
            // for(int i = 1; i < N-1; i++) {
            //     for(int j = 1; j < M-1; j++) {
            //         System.out.print(storages[i][j]+ " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println("------------------------");
        }
        
        int ans = 0;
        for(int i = 1; i < N-1; i++) {
            for(int j = 1; j < M-1; j++) {
                if (storages[i][j] != ' ') ans++;
            }
        }
        
        return ans;
    }
    
    private boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
    
}