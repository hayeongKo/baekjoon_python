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

        int[][] dp = new int[N+1][N+1]; // 가로: 카드 개수 | 세로: 구매가능 카드팩 인덱스
        for(int i = 1; i <= N; i++) {
            dp[1][i] = dp[1][i-1] + p[1];
        }

        for(int i = 2; i <= N; i++) { // 구매가능한 카드팩 인덱스 (카드팩 내 갯수)
            for(int j = 1; j <= N; j++) { // 총 카드 개수
                if(i > j) {
                    dp[i][j] = dp[i-1][j];
                } if(i == j) {
                    dp[i][j] = Math.max(p[j], dp[i-1][j]);
                } else {
                    int maxNum = dp[i-1][j];
                    for(int k = j-1; k >= j/2; k--) {
                        maxNum = Math.max(maxNum, dp[i][k]+dp[i][j-k]);
                    }
                    dp[i][j] = maxNum;
                }
            }
        }
        System.out.println(dp[N][N]);
    }
}