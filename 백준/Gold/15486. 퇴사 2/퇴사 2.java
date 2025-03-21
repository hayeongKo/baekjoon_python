import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] schedules = new int[N+2][2];
        int[] dp = new int[N+2];

        String[] inputs;
        for(int i = 1; i <= N; i++) {
            inputs = br.readLine().split(" ");
            schedules[i][0] = Integer.parseInt(inputs[0]); // 상담시간
            schedules[i][1] = Integer.parseInt(inputs[1]); // 비용
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N+1; i++) {
            if (max < dp[i]) max = dp[i];

            int next = i + schedules[i][0];
            int cost = schedules[i][1];
            if (next <= N+1) {
                dp[next] = Math.max(dp[next], max+cost);
            }
        }
        System.out.println(dp[N+1]);
    }
}