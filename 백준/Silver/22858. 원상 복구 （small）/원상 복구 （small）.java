// 22858
// 원상 복구 (small)

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        // S 초기화
        int[] S = new int[N+1];
        inputs = br.readLine().split(" ");
        for(int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(inputs[i-1]);
        }

        // D 초기화
        int[] D = new int[N+1];
        inputs = br.readLine().split(" ");
        for(int i = 1; i <= N; i++) {
            D[i] = Integer.parseInt(inputs[i-1]);
        }


        int[] P = new int[N+1];
        for(int j = 0; j < K; j++) {
            for(int i = 1; i <= N; i++) {
                P[D[i]] = S[i];
            }
            S = P.clone();
        }

        for(int i = 1; i <= N; i++) {
            System.out.print(P[i] + " ");
        }
    }
}