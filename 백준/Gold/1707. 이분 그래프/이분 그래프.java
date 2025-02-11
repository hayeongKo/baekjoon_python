// 백준 1707
// 이분 그래프
import java.util.*;
import java.io.*;

public class Main {
    static int K, V, E; 
    static Map<Integer, List<Integer>> graph;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        
        while(K-- > 0) {
            String[] inputs = br.readLine().split(" ");
            V = Integer.parseInt(inputs[0]);
            E = Integer.parseInt(inputs[1]);
            graph = new HashMap<>();
            color = new int[V+1];

            for(int i = 1; i <= V; i++) {
                graph.put(i, new ArrayList<>());
            }

            for(int i = 0; i < E; i++) {
                inputs = br.readLine().split(" ");
                int s = Integer.parseInt(inputs[0]);
                int e = Integer.parseInt(inputs[1]);

                graph.get(s).add(e);
                graph.get(e).add(s);
            }

            boolean isBipartite = true;
            for(int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    if(!bfs(i)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    public static boolean bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        color[start] = 1;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int adj : graph.get(node)) {
                if (color[adj] == 0) {
                    color[adj] = -color[node];
                    queue.offer(adj);
                } else if(color[adj] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }
}
