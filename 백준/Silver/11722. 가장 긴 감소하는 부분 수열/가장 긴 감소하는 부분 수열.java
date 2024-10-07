// 11722
// 가장 긴 감소하는 부분 수열

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }
        int[] dp = new int[N];

        for(int i = 0; i < N; i++) { // 헌재 수
            for (int j = 0; j < i; j++) { // 이전 수
                if(nums[i] < nums[j] && dp[i] < dp[j]) { // 이전 수가 현재 수보다 크고, dp값이 이전 수 깂이 더 클 경우
                    dp[i] = dp[j];
                }
            }
            dp[i]++;
        }
    
        int answer = 0;
        for(int i = 0; i < dp.length; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
