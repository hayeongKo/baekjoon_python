import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        String[] inputs = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        System.out.println(res);
    }
}
