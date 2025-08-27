import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> rooms = new PriorityQueue<>();
		int[][] lectures = new int[N][2];
		int ans = 1;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lectures[i][0] = Integer.parseInt(st.nextToken());
			lectures[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(lectures, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
		rooms.offer(lectures[0][1]);
		for(int i = 1; i < N; i++) {
			if (rooms.peek() <= lectures[i][0]) {
				rooms.poll();
			}
			rooms.offer(lectures[i][1]);
			ans = Math.max(rooms.size(), ans);
		}
		
		System.out.println(ans);
	}

}
