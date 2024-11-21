import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dp = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], 1000000);
            dp[i][i] = 0; // 본인한테 가는 비용
        }
        
        for(int[] fare : fares) {
            int t = fare[0];
            int d = fare[1];
            int cost = fare[2];
            dp[t][d] = cost;
            dp[d][t] = cost;
        }
        
        for(int i = 1; i <= n; i++) { // 경유지
            for(int j = 1; j <= n; j++) { // 출발지
                for(int k = 1; k <= n; k++) { // 목적지
                    dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            answer = Math.min(answer, dp[s][i] + dp[i][a] + dp[i][b]);
        }
        return answer;
    }
}