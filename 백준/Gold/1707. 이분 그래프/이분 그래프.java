import java.util.*;
import java.io.*;

public class Main {
    static int K;
    static List<Integer>[] graph;
    static int[] color;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        while(K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph = new ArrayList[v+1];
            color = new int[v+1];

            for(int i = 1; i <= v; i++) graph[i] = new ArrayList<>();

            for(int i =0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                graph[s].add(d);
                graph[d].add(s);
            }

            boolean flag = true;
            for(int i = 1; i <= v; i++) {
                if (color[i] == 0) {
                    if (!bfs(i)) {
                        flag = false;
                        break;
                    }
                }
            }

            System.out.println(flag ? "YES" : "NO");
        }
    }

    public static boolean bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        color[start] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int adj : graph[cur]) {
                if (color[adj] == 0) {
                    color[adj] = -color[cur];
                    q.offer(adj);
                } else if (color[adj] == color[cur]) return false;
            }
        }

        return true;
    }
}
