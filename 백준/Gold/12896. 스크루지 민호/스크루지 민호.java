import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] tree;
    static int[] depth;
    static int N;
    static int maxDepth;
    static boolean[] visited;
    static List<Integer> maxList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        int root = 0;
        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        maxDepth = 0;
        visited = new boolean[N+1];
        depth = new int[N+1];
        List<Integer> list = new ArrayList<>();
        root = 1;
        list.add(root);
        dfs(root, 0, list);

        root = maxList.get(maxList.size()-1);
        maxDepth = 0;
        visited = new boolean[N+1];
        depth = new int[N+1];
        list = new ArrayList<>();
        list.add(root);
        dfs(root, 0, list);
        root = maxList.get(maxList.size()/2);

        maxDepth = 0;
        visited = new boolean[N+1];
        depth = new int[N+1];
        dfs(root, 0);

        System.out.println(maxDepth);
    }

    public static void dfs(int node, int d, List<Integer> list) {
        // System.out.println(Arrays.toString(list.toArray()));
        if (d > maxDepth) {
            maxDepth = d;
            maxList = new ArrayList<>(list);
        }

        maxDepth = Math.max(d, maxDepth);
        depth[node] = d;
        visited[node] = true;

        for(int next : tree[node]) {
            if (visited[next]) continue;
            list.add(next);
            dfs(next, d+1, list);
            list.remove(list.size()-1);
        }
    }

    public static void dfs(int node, int d) {
        // System.out.println(Arrays.toString(list.toArray()));
        if (d > maxDepth) {
            maxDepth = d;
        }

        maxDepth = Math.max(d, maxDepth);
        depth[node] = d;
        visited[node] = true;

        for(int next : tree[node]) {
            if (visited[next]) continue;
            dfs(next, d+1);
        }
    }
}
