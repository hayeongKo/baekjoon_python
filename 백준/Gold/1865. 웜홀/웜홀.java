import java.util.*;
import java.io.*;

public class Main {
	static int N, M, W;
	static List<int[]> edges;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			edges = new ArrayList<>();
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			for(int i = 1; i <= N; i++) {
				edges.add(new int[]{0, i, 0});
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				edges.add(new int[]{s, e, t});
				edges.add(new int[]{e, s, t});
			}
			
			for(int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				edges.add(new int[]{s, e, (-1)*t});
			}
			
			System.out.println(!bellmanFord() ? "YES" : "NO");
		}
	}
	
	public static boolean bellmanFord() {
		long[] dist = new long[N+1];
		Arrays.fill(dist, INF);
		dist[0] = 0;
		
		for(int i = 0; i <= N; i++) {
			for(int[] now : edges) {
				int s = now[0];
				int e = now[1];
				int t = now[2];
				if (dist[s] != INF && dist[e] > dist[s]+t) {
					dist[e] = dist[s]+t;
					if (i == N) return false;
				}
			}
		}
		
		return true;
	}
}
