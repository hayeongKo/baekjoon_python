import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[1000001];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        System.out.println(find(N));
    }

    // topbottom
    public static int find(int n) {
        if (n < 3) return dp[n];
        if (dp[n] > 0) return dp[n];
        dp[n] = (find(n-1) + find(n-2))%15746;
        return dp[n];
    }
}
