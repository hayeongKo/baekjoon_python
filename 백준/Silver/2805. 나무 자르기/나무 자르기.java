import java.io.*;

public class Main {
    static int N;
    static long M;
    static long[] trees;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Long.parseLong(inputs[1]);
        trees = new long[N];

        inputs = br.readLine().split(" ");
        long left = 0;
        long right = 0;
        long answer = 0;

        for(int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(inputs[i]);
            right = Math.max(right, trees[i]);
        }

        while(left <= right) {
            long mid = (left+right)/2;
            long total = 0;

            for(long h : trees) {
                if (mid < h) total += h-mid;
            }

            // 최댓값 -> left
            if (total >= M) {
                answer = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(answer);
    }
}