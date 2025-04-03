import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[] visited;
    static int depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        int u, v = 0;

        for(int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            u = Integer.parseInt(inputs[0]);
            v = Integer.parseInt(inputs[1]);
            
            map[u][v] = map[v][u] = 1;
        }

        int answer = 0;
        for(int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int v) {
        visited[v] = true;

        for(int i = 1; i <= N; i++) {
            if (!visited[i] && map[v][i] == 1) {
                dfs(i);
            }
        }
    }
}