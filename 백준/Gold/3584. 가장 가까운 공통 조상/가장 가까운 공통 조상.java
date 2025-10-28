import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static int N;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0) {
            N = Integer.parseInt(br.readLine());
            parent = new int[N+1];
            visited = new boolean[N+1];

            for(int i = 0; i < N-1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                parent[p] = c;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Set<Integer> set = new HashSet<>();
            int node = u;

            while(true) {
                if (node != 0) {
                    set.add(node);
                    node = parent[node];
                } else {
                    break;
                }
            }

            node = v;
            while(true) {
                if (node != 0) {
                    if (set.contains(node)) {
                        sb.append(node).append("\n");
                        break;
                    }
                    node = parent[node];
                } else {
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
