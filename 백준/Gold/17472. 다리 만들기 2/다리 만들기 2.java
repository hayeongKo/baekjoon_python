import java.util.*;
import java.io.*;

public class Main {
	static int[][] island;
	static int N, M;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static Map<Integer, List<int[]>> islandPos;
	static int color;
	
	static int[] parent, rank;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		island = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				island[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// bfs로 섬 분류
		visited = new boolean[N][M];
		islandPos = new HashMap<>();
		color = 1;
		List<int[]> starter = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if (island[i][j] == 1 && !visited[i][j]) {
					starter.add(new int[]{color, i, j});
					islandPos.put(color, new ArrayList<>());
					bfs(i, j, color);
					color++;
				}
			}
		}
		color--;
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(island[i]));
//		}
		
		// bfs로 최소 다리 길이 확인 + 그래프 만들기
		// 아무 점에서 출발해서 출발지 색이랑 똑같으면 count x
		// 추가 : 중간에 꺾이면 안됨
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return o1[2]-o2[2];
		});
		
		for(int i = 1; i <= color; i++) {
			int[] weight = makeBridge(i, islandPos.get(i));
//			System.out.println("weight: " + Arrays.toString(weight));
			for(int j = 1; j <= color; j++) {
				if (i == j) continue;
				pq.offer(new int[]{i, j, weight[j]});
			}
		}
		
		// 크루스칼로 MST 만들기
		parent = new int[color+1];
		for(int i = 1; i <= color; i++) parent[i] = i;
		rank = new int[color+1];
		for(int i = 1; i <= color; i++) rank[i] = 1;
		
		int ans = 0;
		int cnt = 0;
		while(cnt < color-1) {
			int[] cur = pq.poll();
			if (union(cur[0], cur[1])) {
//				System.out.println("connect: " + Arrays.toString(cur));
				if (cur[2] == Integer.MAX_VALUE) {
					ans = -1;
					break;
				}
				cnt++;
				ans+=cur[2];
			}
		}
		
		System.out.println(ans);
	}
	
	public static int find(int n) {
		if (parent[n] != n) {
			parent[n] = find(parent[n]);
		}
		return parent[n];
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
	
	public static int[] makeBridge(int c, List<int[]> pos) {
		int[] dist = new int[color+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int[] p : pos) {
			int x = p[0];
			int y = p[1];
			
			for(int d = 0; d < 4; d++) {
				int step = 1;
				while(true) {
					int nx = x+dx[d]*step;
					int ny = y+dy[d]*step;
					
					if (!inRange(nx, ny) || island[nx][ny] == c) break;
					
					if (island[nx][ny] == 0) {
						step++;
						continue;
					} else if (island[nx][ny] > 0) {
						if (step >= 3) {
							int other = island[nx][ny];
							dist[other] = Math.min(dist[other], step-1);
						}
						break;
					}
				}
			}
		}
		
		return dist;
	}
	
	
	public static void bfs(int x, int y, int color) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{x, y});
		visited[x][y] = true;
		island[x][y] = color;
		islandPos.get(color).add(new int[]{x, y});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			x = cur[0];
			y = cur[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (!inRange(nx, ny) || visited[nx][ny] || island[nx][ny] != 1) continue;
				visited[nx][ny] = true;
				island[nx][ny] = color;
				q.offer(new int[]{nx, ny});
				islandPos.get(color).add(new int[]{nx, ny});
			}
		}
	}
	
	public static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
