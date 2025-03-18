import java.util.*;
import java.io.*;

public class Main {
    static int N, M, V;
    static boolean[][] graph;
    static boolean[] visitedDFS;
    static boolean[] visitedBFS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        V = Integer.parseInt(inputs[2]);
        
        graph = new boolean[N+1][N+1];
        visitedDFS = new boolean[N+1];
        visitedBFS = new boolean[N+1];

        int s = 0, e = 0;
        for(int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            s = Integer.parseInt(inputs[0]);
            e = Integer.parseInt(inputs[1]);
            graph[s][e] = graph[e][s] = true;
        }
        dfs(V);
        System.out.println();
        bfs(V);
    }

    public static void dfs(int v) {
        System.out.print(v + " ");
        visitedDFS[v] = true;
        
        for(int i = 1; i <= N; i++) {
            if (graph[v][i] && !visitedDFS[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visitedBFS[v] = true;
        queue.offer(v);

        while(!queue.isEmpty()) {
            int now = queue.pop();
            System.out.print(now+" ");
            for(int i = 1; i <= N; i++) {
                if(graph[now][i] && !visitedBFS[i]) {
                    visitedBFS[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}