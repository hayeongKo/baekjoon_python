import java.io.*;
import java.util.*;

public class Main {
	static int V, E;
	static int[] p, r;
	static class Edge implements Comparable<Edge> {
		int s, e, w;
		Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
	}
	static long min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Edge> points = new PriorityQueue<>();
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			points.offer(new Edge(s, e, w));
		}
		
		// makeset
		p = new int[V+1];
		r = new int[V+1];
		for(int i = 1; i <= V; i++) {
			p[i] = i;
			r[i] = i;
		}
		
		min = 0;
		int cnt = 0;
		while(cnt < V-1) {
			Edge edge = points.poll();
			// 연결이 안됐다면 다음으로 진행
			if (union(edge.s, edge.e)) {
				cnt++;
				min+=edge.w;
			}
		}
		System.out.println(min);
	}
	
	public static int find(int n) {
		if (p[n] != n) {
			p[n] = find(p[n]);
		}
		return p[n];
	}

	public static boolean union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		
		// 연결 됐다면
		if (ra == rb) {
			return false;
		} else {
			// 연결 안됐다면
			if (r[ra] < r[rb]) {
				p[ra]=rb;
				r[rb]+=ra;
			} else {
				p[rb]=ra;
				r[ra]+=rb;
			}
			return true;
		}
	}
}
