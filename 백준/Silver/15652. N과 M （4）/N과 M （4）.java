import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]); // 1~N 사이
        M = Integer.parseInt(inputs[1]); // 길이

        visited = new boolean[N+1];
        dfs(0, new ArrayList<>());

    }

    public static void dfs(int depth, List<Integer> list) {
        if (depth == M) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++) {
            if (list.size() == 0 || (list.size() > 0 && list.get(list.size()-1) <= i)) {
                list.add(i);
                dfs(depth+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}