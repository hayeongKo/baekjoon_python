import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]); // 1~N 사이
        M = Integer.parseInt(inputs[1]); // 길이

        dfs(0, new ArrayList<>());
        System.out.print(sb);
    }

    public static void dfs(int depth, List<Integer> list) {
        if (depth == M) {
            for(Integer i : list) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            list.add(i);
            dfs(depth+1, list);
            list.remove(list.size()-1);
        }
    }
}