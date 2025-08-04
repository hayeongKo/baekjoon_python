import java.util.*;
import java.io.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int N, E;
	static Map<Integer, Map<Integer, Integer>> graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 1 -> v1 -> v2 -> N
		// 1 -> v2 -> v1 -> N

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new HashMap<>();
		for(int i = 1; i <= N; i++) {
			graph.put(i, new HashMap<>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).put(b, c);
			graph.get(b).put(a, c);
		}
		
		int v1 = 0, v2 = 0;
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		long sum1 = 0, sum2 = 0;
		int[] d1 = dijkstra(1);
		sum1+=d1[v1];
		int[] d2 = dijkstra(v1);
		sum1+=d2[v2];
		int[] d3 = dijkstra(v2);
		sum1+=d3[N];
		
		sum2+=d1[v2];
		d2 = dijkstra(v2);
		sum2+=d2[v1];
		d3 = dijkstra(v1);
		sum2+=d3[N];
		
		System.out.println(Math.min(sum1, sum2) >= INF ? -1 : Math.min(sum1, sum2));
	}
	
	public static int[] dijkstra(int start) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		dist[start] = 0;
		boolean[] visited = new boolean[N+1];
		
		while(true) {
			int u = getMin(dist, visited);
			if (u == 0) break;
			visited[u] = true;
			
			for(int v : graph.get(u).keySet()) {
				if (!visited[v]) {
					dist[v] = Math.min(dist[v], dist[u]+graph.get(u).get(v));
				}
			}
		}
		
		return dist;
	}
	
	public static int getMin(int[] dist, boolean[] visited) {
		int min = INF;
		int node = 0;
		
		for(int i = 1; i <= N; i++) {
			if (!visited[i] && min > dist[i]) {
				min = dist[i];
				node = i;
			}
		}
		
		return node;
	}

}
