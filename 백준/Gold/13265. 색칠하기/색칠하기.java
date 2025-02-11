import java.io.*;
import java.util.*;

public class Main {
    static int T, n, m;
    static Map<Integer, List<Integer>> graph;
    static int[] color;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String[] inputs = br.readLine().split(" ");
            n = Integer.parseInt(inputs[0]);
            m = Integer.parseInt(inputs[1]);
            graph = new HashMap<>();
            color = new int[n+1];
            
            for(int i = 1; i <= n; i++) {
                graph.put(i, new ArrayList<>());
            }

            for(int i = 0; i < m; i++) {
                inputs = br.readLine().split(" ");
                int s = Integer.parseInt(inputs[0]);
                int e = Integer.parseInt(inputs[1]);

                graph.get(s).add(e);
                graph.get(e).add(s);
            }

            boolean isPossible = true;
            for(int i = 1; i <= n; i++) {
                if (color[i] == 0) {
                    if(!bfs(i)) {
                        isPossible = false;
                        break;
                    }
                }
            }
            System.out.println(isPossible ? "possible" : "impossible");
        }
    }

    public static boolean bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        color[start] = 1;
        queue.offer(start);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int adj : graph.get(node)) {
                if (color[adj] == 0) {
                    color[adj] = -color[node];
                    queue.offer(adj);
                } else if (color[adj] == color[node]) return false;
            }
        }
        return true;
    }
}
