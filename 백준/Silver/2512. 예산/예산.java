// 이분 탐색
// 2512
// 예산

import java.io.*;


public class Main {
    static int N;
    static int[] budgets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        budgets = new int[N];

        int sum = 0;
        int high = 0;
        String[] inputs = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(inputs[i]);
            sum += budgets[i];
            high = Math.max(high, budgets[i]);
        }

        int totalBudget = Integer.parseInt(br.readLine());

        if(sum <= totalBudget) {
            System.out.println(high);
            return;
        }

        int low = -1;

        while(low < high -1) {
            int mid = (low + high) / 2;

            if(f(mid) > totalBudget) {
                high = mid;
            } else {
                low = mid;
            }
        }
        
        System.out.println(low);
    }

    public static int f(int h) {
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += Math.min(budgets[i], h);
        }
        return total;
    }
}