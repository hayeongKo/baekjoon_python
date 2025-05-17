import java.io.*;
import java.util.*;

public class Main {
    static int K, V, E;
    static List<Integer>[] graph;
    static int[] color;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        String[] inputs;

        while(K-- > 0) {
            inputs = br.readLine().split(" ");
            V = Integer.parseInt(inputs[0]);
            E = Integer.parseInt(inputs[1]);
            graph = new ArrayList[V+1];
            color = new int[V+1];

            for(int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

            for(int i = 0; i < E; i++) {
                inputs = br.readLine().split(" ");
                int s = Integer.parseInt(inputs[0]);
                int e = Integer.parseInt(inputs[1]);
                graph[s].add(e);
                graph[e].add(s);
            }

            boolean isBipart = true;
            for(int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    if (!bfs(i)) {
                        isBipart = false;
                        break;
                    }
                }
            }

            System.out.println(isBipart ? "YES" : "NO");
        }
    }

    public static boolean bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        color[start] = 1;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int adj : graph[now]) {
                if (color[adj] == 0) {
                    color[adj] = -color[now];
                    queue.offer(adj);
                } else if (color[adj] == color[now]) return false;
            }
        }
        
        return true;
    }
}