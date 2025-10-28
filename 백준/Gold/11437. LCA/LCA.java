import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<Integer>[] tree;
    static int[] parent;
    static int[] depth;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for(int i = 0; i < N-1; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        parent = new int[N+1];
        depth = new int[N+1];
        visited = new boolean[N+1];

        // 트리 기반 높이 채우기
        dfs(1, 0);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(M-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            sb.append(lca(u, v)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int lca(int u, int v) {
        // System.out.println("before : " + u + " " + v);
        // System.out.println("before : " + depth[u] + " " + depth[v]);
        while(depth[u] > depth[v]) u = parent[u];
        while(depth[u] < depth[v]) v = parent[v];
        // System.out.println("after : " + u + " " + v);
        // System.out.println("after : " + depth[u] + " " + depth[v]);

        while(u != v) {
            u = parent[u];
            v = parent[v];
        }
        // System.out.println("-----------");
        return u;
    }

    public static void dfs(int node, int d) {
        // System.out.println("init: " + node + " " + d);
        visited[node] = true;
        depth[node] = d;
        
        for(int next : tree[node]) {
            if (!visited[next]) {
                parent[next] = node;
                dfs(next, d+1);
            }
        }
    }
}
