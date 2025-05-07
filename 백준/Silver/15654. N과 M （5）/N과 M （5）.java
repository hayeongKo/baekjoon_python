import java.io.*;
import java.util.*;

// N과 M (5)
public class Main {
    static int N, M;
    static int[] nums;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        nums = new int[N];
        visited = new boolean[N];
        inputs = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(nums);
        dfs(0, new ArrayList<>());
    }

    public static void dfs(int depth, List<Integer> list) {
        if (depth == M) {
            for(Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(depth+1, list);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}