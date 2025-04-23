import java.util.*;
import java.io.*;

public class Main {
    static int[] A;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        TreeSet<Integer> ts = new TreeSet<>();

        String[] inputs = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(inputs[i]);
            ts.add(A[i]);
        }

        Arrays.sort(A);

        int low = 0;
        int high = N;

        int M = Integer.parseInt(br.readLine());
        inputs = br.readLine().split(" ");
        int X;

        // for(int i = 0; i < M; i++) {
        //     X = Integer.parseInt(inputs[i]);
        //     while(low < high-1) {
        //         int mid = (low+high)/2;
        //         if (A[mid] < X) {
        //             low = mid;
        //         } else {
        //             high = mid;
        //         }
        //     }

        //     System.out.println("low: " + low + " A[low]: " + A[low]);
        //     if (A[low] == X) System.out.println(1);
        //     else System.out.println(0);
        // }

        for(int i = 0; i < M; i++) {
            X = Integer.parseInt(inputs[i]);
            if (ts.contains(X)) System.out.println(1);
            else System.out.println(0);

            // System.out.println("low: " + low + " A[low]: " + A[low]);
            // if (A[low] == X) System.out.println(1);
            // else System.out.println(0);
        }
        
        
    }
}