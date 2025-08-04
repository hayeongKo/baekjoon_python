import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] cheeses;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cheeses = new int[N][M];
		int cheesesCnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				cheeses[i][j] = Integer.parseInt(st.nextToken());
				if (cheeses[i][j] == 1) cheesesCnt++;
			}
		}
		
		int t = 0;
		int last = 0;
		while(true) {
			if (cheesesCnt == 0) break;
			last = bfs();
			cheesesCnt-=last;
			t++;
		}
		System.out.println(t);
		System.out.println(last);
	}
	
	public static int bfs() {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{0, 0});
		visited[0][0] = true;
		List<int[]> melt = new ArrayList<>();
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = now[0]+dx[i];
				int ny = now[1]+dy[i];
				
				if (!inRange(nx, ny) || visited[nx][ny]) continue;
				int[] tmp = new int[]{nx, ny};
				visited[nx][ny] = true;
				// 치즈면 지울거임
				if (cheeses[nx][ny] == 1) {
					melt.add(tmp);
				} else { // 아니면 이동할거임
					q.offer(tmp);
				}
			}
		}
		
		for(int[] p : melt) {
			cheeses[p[0]][p[1]] = 0;
		}
		
		return melt.size();
	}
	
	public static boolean inRange(int nx, int ny) {
		if (nx < 0 || nx >= N || ny < 0 || ny >= M) return false;
		return true;
	}

}
