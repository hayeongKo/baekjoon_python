import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] scores = new int[10000];
        for(int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[10000];

        dp[0] = 0;
        dp[1] = scores[1];
        dp[2] = scores[1] + scores[2];
        for(int i = 3; i <= N; i++) {
            dp[i] = Math.max(scores[i]+scores[i-1]+dp[i-3], scores[i]+dp[i-2]);
        }
        System.out.println(dp[N]);
    }
}
