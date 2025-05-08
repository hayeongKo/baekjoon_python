import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(n, computers, i);
                ans++;
            }
        }
        
        return ans;
    }
    
    public void bfs(int n, int[][] computers, int v) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(v);
        
        while(!queue.isEmpty()) {
            Integer now = queue.pop();
            
            for(int i = 0; i < n; i++) {
                if (!visited[i] && computers[now][i] == 1) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
