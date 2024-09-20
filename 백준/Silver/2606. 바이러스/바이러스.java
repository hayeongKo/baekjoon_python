// 2606
// 바이러스

import java.util.*;
import java.io.*;

public class Main {
    static int N, V;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int cnt = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs;

        N = Integer.parseInt(br.readLine());
        V = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];

        for(int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++) {
            inputs = br.readLine().split(" ");
            graph.get(Integer.parseInt(inputs[0])).add(Integer.parseInt(inputs[1]));
            graph.get(Integer.parseInt(inputs[1])).add(Integer.parseInt(inputs[0]));
        }

        dfs(1);
        System.out.print(cnt);
    }

    public static void dfs(int v) {
        visited[v] = true;
        cnt++;

        for(Integer i: graph.get(v)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}