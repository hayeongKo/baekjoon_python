import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static Map<Integer, List<Integer>> smaller, taller;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		smaller = new HashMap<>();
		taller = new HashMap<>();
		int ans = 0;
		
		for(int i = 1; i <= N; i++) {
			smaller.put(i, new ArrayList<>());
			taller.put(i, new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			taller.get(x).add(y);
			smaller.get(y).add(x);
		}
		
		for(int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			int tCnt = dfs(i, taller);
			
			visited = new boolean[N+1];
			int sCnt = dfs(i, smaller);
			
//			System.out.println(tCnt+" "+sCnt);
			if (tCnt+sCnt==N-1) ans++;
		}
		
		System.out.println(ans);
	}
	
	public static int dfs(int cur, Map<Integer, List<Integer>> graph) {
		visited[cur] = true;
		int count = 0;
		
		for(int next : graph.get(cur)) {
			if (!visited[next]) {
				count+=1+dfs(next, graph);
			}
		}
		return count;
	}
	

}
