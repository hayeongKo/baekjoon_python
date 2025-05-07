import java.io.*;

// 부분수열의 합
public class Main {
    static int N, S;
    static int[] nums;
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        S = Integer.parseInt(inputs[1]);
        nums = new int[N];

        inputs = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        dfs(0,0);
        if (S==0) ans--; // 공집합 제외
        System.out.println(ans);
    }

    public static void dfs(int depth, int target) {
        if (depth == N) {
            if (target == S) ans++;
            return;
        }
        
        dfs(depth+1, target+nums[depth]);
        dfs(depth+1, target);
    }
}