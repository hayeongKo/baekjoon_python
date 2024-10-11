// 2294
// 동전 2

import java.io.*;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);
        int[] coins = new int[N];
        int[] dp = new int[K+1];

        for(int i = 1; i < dp.length; i++) {
            dp[i] = 100001;
        }

        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= K; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }

        if(dp[K] > 100000) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }
    }
}