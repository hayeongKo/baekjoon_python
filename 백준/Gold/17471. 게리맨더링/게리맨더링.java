import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static List<Integer>[] graph;
	static int[] people;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		people = new int[N+1];
		ans = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j < cnt; j++) {
				graph[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		List<Integer> red = new ArrayList<>();
		List<Integer> blue = new ArrayList<>();
		
		divideTeam(1, red, blue);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	public static void divideTeam(int d, List<Integer> red, List<Integer> blue) {
		if (d == N+1) {
			if (red.size() != 0 && blue.size() != 0) {
				if (visit(red) && visit(blue)) {
					ans = Math.min(ans, Math.abs(getPeopleSum(red)-getPeopleSum(blue)));
				}
			}
			return;
		}
		
		red.add(d);
		divideTeam(d+1, red, blue);
		red.remove(red.size()-1);
		blue.add(d);
		divideTeam(d+1, red, blue);
		blue.remove(blue.size()-1);
	}
	
	public static int getPeopleSum(List<Integer> cities) {
		int sum = 0;
		for(int city : cities) {
			sum += people[city];
		}
		return sum;
	}
	
	public static boolean visit(List<Integer> list) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		queue.add(list.get(0));
		visited[list.get(0)] = true;
		
		while(!queue.isEmpty()) {
			Integer now = queue.poll();
			for(Integer adj : graph[now]) {
				if (!visited[adj] && list.contains(adj)) {
					visited[adj] = true;
					queue.offer(adj);
				}
			}
		}
		
		for(Integer city : list) {
			if (!visited[city]) return false;
		}
		return true;
	}
}
