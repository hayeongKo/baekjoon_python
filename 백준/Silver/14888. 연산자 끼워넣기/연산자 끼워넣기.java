import java.io.*;

// 연산자 끼워넣기

public class Main {
    static int N;
    static int[] nums;
    static int[] how;
    static int min, max;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][4];
        nums = new int[N];
        how = new int[4];

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        String[] inputs = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        inputs = br.readLine().split(" ");
        for(int i = 0; i < 4; i++) {
            how[i] = Integer.parseInt(inputs[i]);
        }

        dfs(nums[0], 1);

        System.out.println(max);
        System.out.println(min);
    }
    
    public static void dfs(int value, int depth) {
        if (depth == N) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if (how[i] > 0) {
                how[i]--;
                if (i == 0) dfs(value+nums[depth], depth+1);
                else if (i == 1) dfs(value-nums[depth], depth+1);
                else if (i == 2) dfs(value*nums[depth], depth+1);
                else if (i == 3) dfs(value/nums[depth], depth+1);
                how[i]++;
            }
        }
    }
}