import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] graph;
    static boolean[] visited;
    static int res = 0;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        int s, e = 0;
        String[] inputs;
        for(int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            s = Integer.parseInt(inputs[0]);
            e = Integer.parseInt(inputs[1]);

            graph[s][e] = graph[e][s] = true;
        }
        dfs(1);
        System.out.println(res);
    }

    public static void dfs(int v) {
        visited[v] = true;
        for (int i = 1; i <= N; i++) {
            if(graph[v][i] && !visited[i]) {
                res++;
                dfs(i);
            }
        }
    }
}