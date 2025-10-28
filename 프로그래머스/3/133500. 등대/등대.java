import java.util.*;

class Solution {
    List<Integer>[] tree;
    boolean[] visited;
    int[][] dp;
    int N;
    
    public int solution(int n, int[][] lighthouse) {
        this.N = n;
        
        tree = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) tree[i] = new ArrayList<>();
        
        for(int i = 0; i < N-1; i++) {
            int a = lighthouse[i][0];
            int b = lighthouse[i][1];
            
            tree[a].add(b);
            tree[b].add(a);
        }
        
        visited = new boolean[N+1];
        dp = new int[N+1][2];
        
        dfs(1);
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    public void dfs(int node) {
        visited[node] = true;
        dp[node][1] = 1;
        
        for(int next : tree[node]) {
            if (visited[next]) continue;
            dfs(next);
            dp[node][0]+=dp[next][1];
            dp[node][1]+=Math.min(dp[next][0], dp[next][1]);
        }
    }
}