// 11052
// 카드 구매하기

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        int[] p = new int[N+1];
        for(int i = 1; i <= N; i++) {
            p[i] = Integer.parseInt(inputs[i-1]);
        }

        int[] dp = new int[N+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j]+p[j]);
            }
        }
        System.out.println(dp[N]);
    }
}