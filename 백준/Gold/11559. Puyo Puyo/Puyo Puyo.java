import java.util.*;
import java.io.*;

public class Main {
	static char[][] board;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static List<int[]> combos;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new char[12][6];
		
		for(int i = 0; i < 12; i++) {
			String ss = br.readLine();
			for(int j = 0; j < 6; j++) {
				board[i][j] = ss.charAt(j);
			}
		}
		
		int ans = 0;
		while(true) {
			if (findCombo() == 0) break;
			bomb();
			goDown();
			ans++;
		}
		System.out.println(ans);
	}
	
	public static void goDown() {
		Queue<Character> q = new LinkedList<>();
		
		for(int j = 0; j < 6; j++) {
			for(int i = 11; i >= 0; i--) {
				if (board[i][j] != '.') {
					q.offer(board[i][j]);
				}
			}
			
			int i = 11;
			while(!q.isEmpty()) {
				board[i--][j] = q.poll();
			}
			
			for(int ii = i; i >= 0; i--) {
				board[i][j] = '.';
			}
		}
		
//		for(int i = 0; i < 12; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
//		System.out.println("------------------");
	}
	
	public static void bomb() {
		for(int[] combo : combos) {
			board[combo[0]][combo[1]] = '.';
		}
	}
	
	public static int findCombo() {
		combos = new ArrayList<>();
		visited = new boolean[12][6];
		
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 6; j++) {
				if (!visited[i][j] && board[i][j] != '.') {
					List<int[]> res = bfs(i, j);
					if (res.size() >= 4) combos.addAll(res);
				}
			}
		}
		
		return combos.size();
	}
	
	public static List<int[]> bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{x, y});
		char puyo = board[x][y];
		visited = new boolean[12][6];
		
		List<int[]> tmp = new ArrayList<>();
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			x = cur[0];
			y = cur[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (inRange(nx, ny) && !visited[nx][ny] && board[nx][ny]==puyo) {
					visited[nx][ny] = true;
					int[] p = new int[]{nx, ny};
					tmp.add(p);
					q.offer(p);
				}	
			}
		}
		
		return tmp;
	}
	
	public static boolean inRange(int nx, int ny) {
		return nx >= 0 && nx < 12 && ny >= 0 && ny < 6;
	}

}
