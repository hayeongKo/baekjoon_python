// 1260
// DFS와 BFS

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, V;
    static int[][] map;
    static boolean[] visitedDfs;
    static boolean[] visitedBfs;
    static ArrayDeque<Integer> queue = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        V = Integer.parseInt(inputs[2]);

        map = new int[N+1][N+1];

        for(int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            map[Integer.parseInt(inputs[0])][Integer.parseInt(inputs[1])] = map[Integer.parseInt(inputs[1])][Integer.parseInt(inputs[0])] = 1;
        }

        visitedDfs = new boolean[N+1];
        visitedBfs = new boolean[N+1];
        dfs(V);
        System.out.println();
        bfs(V);
    }

    public static void dfs(int v) {
        System.out.print(v+" ");
        visitedDfs[v] = true;

        for(int j = 0; j<= N; j++) {
            if (map[v][j] == 1 && !visitedDfs[j]) {
                dfs(j);
            }
        }
    }

    public static void bfs(int v) {
        System.out.print(v+" ");
        visitedBfs[v] = true;
        queue.offer(v);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for(int j = 0; j <= N; j++) {
                if (map[temp][j] == 1 && !visitedBfs[j]) {
                    visitedBfs[j] = true;
                    System.out.print(j+" ");
                    queue.offer(j);
                }
            }
        }
        
    }
}
