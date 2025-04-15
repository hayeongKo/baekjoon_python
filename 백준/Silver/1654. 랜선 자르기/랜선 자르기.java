import java.io.*;

public class Main {
    static int K, N;
    static long[] lines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        K = Integer.parseInt(inputs[0]);
        N = Integer.parseInt(inputs[1]);

        lines = new long[K];
        long high = 0;

        for(int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine());
            high = Math.max(high, lines[i]);
        }
        
        high++;

        long low = 0;
        while(low < high-1) {
            long mid = (low+high)/2;
            if (f(mid) < N) {
                high = mid;
            } else {
                low = mid;
            }
        }

        System.out.println(low);
        
    }

    public static long f(long mid) {
        long cnt = 0;
        for(long line : lines) {
            cnt += line/mid;
        }
        return cnt;
    }
}