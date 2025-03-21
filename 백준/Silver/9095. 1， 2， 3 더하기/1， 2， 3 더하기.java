import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[12];

        dp[1] = 1;
        dp[2] = 2; // 1 1 , 2
        dp[3] = 4; 

        int T;
        for(int i = 0; i < N; i++) {
            T = Integer.parseInt(br.readLine());

            if (T < 4) {
                System.out.println(dp[T]);
            } else {
                if (dp[T] == 0) {
                    for(int j = 3; j <= T; j++) {
                        if (dp[j] > 0) continue;
                        else {
                            dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
                        }
                    }
                }
                System.out.println(dp[T]);
            }
        }
    }
}