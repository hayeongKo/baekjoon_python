import java.io.*;

public class Main {
    static long[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N;

        p = new long[101];
        p[1] = 1;
        p[2] = 1;
        p[3] = 1;
        p[4] = 2;
        p[5] = 2;

        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            System.out.println(dp(N));
        }
    }

    public static long dp(int n) {
        if (p[n] != 0) {
            return p[n];
        }
        p[n] = dp(n-1) + dp(n-5);
        return p[n];
    }
}