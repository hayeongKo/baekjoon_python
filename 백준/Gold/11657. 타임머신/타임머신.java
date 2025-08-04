import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static List<Bus> graph;
	static final int INF = Integer.MAX_VALUE;
	static long[] dist;
	static boolean[] holes;
	static class Bus {
		int s, e, w;
		Bus(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			graph.add(new Bus(s, e, t));
		}
		
		if (!bellmanFord(1)) {
			System.out.println(-1);
		} else {
			for(int i = 2; i <= N; i++) {
				System.out.println(dist[i] == INF ? -1 : dist[i]);
			}
		}
	}
	
	public static boolean bellmanFord(int start) {
		dist = new long[N+1];
		Arrays.fill(dist, INF);
		holes = new boolean[N+1];
		
		dist[start] = 0;
		for(int v = 1; v <= N; v++) {
			for(Bus bus : graph) {
				long weight = dist[bus.s]+bus.w;
				if (dist[bus.s] != INF && dist[bus.e] > weight) {
					dist[bus.e] = weight;
					if (v == N) return false;
				}
			}
		}
		
		return true;
	}
}
