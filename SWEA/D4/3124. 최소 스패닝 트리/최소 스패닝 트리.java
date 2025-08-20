import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			List<int[]>[] graph = new ArrayList[V+1];
			for(int i = 1; i <= V; i++) graph[i] = new ArrayList<>();
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				graph[s].add(new int[]{e, w});
				graph[e].add(new int[]{s, w});
			}
			
			int[] d = new int[V+1];
			boolean[] visited = new boolean[V+1];
			
			Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
				return o1[1]-o2[1];
			});
			
			pq.offer(new int[]{1, 0});
			int cnt = 0;
			while(true) {
				if (cnt == V) break;
				int[] cur = new int[]{};
//				for(int[] i : pq) {
//					System.out.println(Arrays.toString(i));
//				}
//				System.out.println("-----------");
				while(!pq.isEmpty()) {
					cur = pq.poll();
					if (visited[cur[0]]) continue;
					break;
				}
//				System.out.println("cur: "+Arrays.toString(cur));
				cnt++;
				visited[cur[0]]=true;
				d[cur[0]]=cur[1];
				for(int[] next : graph[cur[0]]) {
//					System.out.println("next:"+Arrays.toString(next));
					pq.offer(next);
				}
			}
			
			long ans = 0;
			for(int cost : d) {
				ans+=cost;
			}
			
			System.out.println("#"+t+" "+ans);
		}

	}

}
