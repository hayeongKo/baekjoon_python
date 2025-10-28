import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;
    static int N;
    static List<Integer>[] tree;
    static int[] people;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        people = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) people[i] = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        dp = new int[N+1][2];
        visited = new boolean[N+1];
        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    public static void dfs(int node) {
        visited[node] = true;
        dp[node][1] = people[node];

        for(int next : tree[node]) {
            if (visited[next]) continue;
            dfs(next);
            dp[node][0] += Math.max(dp[next][1], dp[next][0]);
            dp[node][1] += dp[next][0];
        }
    }
}
