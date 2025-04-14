import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        
        int[] arr = new int[N];
        int[] dp = new int[N];
        int answer = Integer.MIN_VALUE;
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }
        
        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j]+1) {
                    dp[i] = dp[j]+1;
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        
        System.out.println(answer);
    }
}