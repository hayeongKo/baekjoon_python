class Solution {
    static int ans;
    static boolean[][][] visited;
    public int solution(int[][] info, int n, int m) {
        ans = Integer.MAX_VALUE;
        visited = new boolean[n+1][m+1][info.length+1];
        
        dfs(info, n, m, 0, 0, 0);
        
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
    
    public static void dfs(int[][] info, int n, int m, int a, int b, int depth) {
        if (a >= n || b >= m || visited[a][b][depth]) return;
        visited[a][b][depth] = true;
        
        if (depth == info.length) {
            ans = Math.min(ans, a);
            return;
        }
        
        dfs(info, n, m, a+info[depth][0], b, depth+1);
        dfs(info, n, m, a, b+info[depth][1], depth+1);
    }
}