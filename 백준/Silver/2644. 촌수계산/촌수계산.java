import java.util.*;
import java.io.*;

public class Main {
    static int N, M, target1, target2;
    static boolean[][] graph;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        target1 = Integer.parseInt(inputs[0]);
        target2 = Integer.parseInt(inputs[1]);
        M = Integer.parseInt(br.readLine());
        graph = new boolean[N+1][N+1];
        visited = new boolean[N+1];
        answer = 0;

        int s, e = 0;
        for(int i = 0; i < M;i++) {
            inputs = br.readLine().split(" ");
            s = Integer.parseInt(inputs[0]);
            e = Integer.parseInt(inputs[1]);
            graph[s][e] = graph[e][s] = true;
        }

        dfs(target1, 0);

        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void dfs(int v, int depth) {
        if (v == target2) {
            answer = depth;
        } else {
            for(int i = 1; i <= N; i++) {
                if (graph[v][i] && !visited[i]) {
                    visited[i] = true;
                    dfs(i, depth+1);
                }
            }
        } 
    }
}