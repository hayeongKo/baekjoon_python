import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static double rate;
	static int[] parent, rank;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			List<Integer> xs = new ArrayList<>();
			List<Integer> ys = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				xs.add(Integer.parseInt(st.nextToken()));
			}
			
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				ys.add(Integer.parseInt(st.nextToken()));
			}
			
			rate = Double.parseDouble(br.readLine());
			
			//int[] = s, e, w
			PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> {
				return Double.compare(o1[2], o2[2]);
			});
			
			parent = new int[N];
			for(int i = 0; i < N; i++) parent[i] = i;
			rank = new int[N];
			for(int i = 0; i < N; i++) rank[i] = 1;
			
			for(int i = 0; i < N-1; i++) {
				int tx = xs.get(i);
				int ty = ys.get(i);
				for(int j = i+1; j < N; j++) {
					int cx = xs.get(j);
					int cy = ys.get(j);
					pq.offer(new double[]{i, j, Math.pow(tx-cx, 2)+Math.pow(ty-cy, 2)});
				}
			}
			
			
			double ans = 0;
			int cnt = 0;
			while(cnt < N-1) {
				double[] cur = pq.poll();
				if (union((int) cur[0], (int) cur[1])) {
//					System.out.println(Arrays.toString(cur));
					cnt++;
					ans += cur[2]*rate;
				}
			}
			
			System.out.printf("#%d %d\n", t, Math.round(ans));
		}
		
		
		
		
	}
	
	public static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) {
			return false;
		} else {
			if (rank[x] < rank[y]) {
				parent[x] = y;
				rank[y]+=rank[x];
			} else {
				parent[y] = x;
				rank[x]+=rank[y];
			}
			return true;
		}
	}

}
