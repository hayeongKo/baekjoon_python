import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cost = new int[N+1];
        int[] customer = new int[N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            customer[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][C*101];
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= C*101; j++) {
                if (j >= cost[i]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-cost[i]]+customer[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }

                if (dp[i][j] >= C) {
                    ans = Math.min(j, ans);
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
