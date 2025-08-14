import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map, dist;
	static List<int[]> chickens;
	static List<int[]> houses;
	static long ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		chickens = new ArrayList<>();
		houses = new ArrayList<>();
		ans = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					houses.add(new int[]{i, j});
				} else if (map[i][j] == 2) {
					chickens.add(new int[]{i, j});
				}
			}
		}
		
		dist = new int[houses.size()][chickens.size()];
		
		for(int h = 0; h < houses.size(); h++) {
			for(int c = 0; c < chickens.size(); c++) {
				int[] house = houses.get(h);
				int[] chicken = chickens.get(c);
				dist[h][c] = Math.abs(house[1]-chicken[1])+Math.abs(house[0]-chicken[0]);
			}
		}
		
//		for(int h = 0; h < houses.size(); h++) {
//			System.out.println(Arrays.toString(dp[h]));
//		}
		
		dfs(0, new ArrayList<>());
		System.out.println(ans);
	}
	
	public static void dfs(int start, List<Integer> visited) {
		if (visited.size() == M) {
			ans = Math.min(ans, countD(visited));
			return;
		}
		
		for(int i = start; i < chickens.size(); i++) {
//			System.out.println(Arrays.toString(visited.toArray()));
			visited.add(i);
			dfs(i+1, visited);
			visited.remove(visited.size()-1);
		}
	}
	
	public static long countD(List<Integer> visited) {
		long d = 0;
		for(int h = 0; h < houses.size(); h++) {
			int t = Integer.MAX_VALUE;
			for(int c : visited) {
				t = Math.min(t, dist[h][c]);
			}
			d+=t;
		}
		return d;
	}

}
