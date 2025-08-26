import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int res = 1;
			int[][] scores = new int[N][2];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int f = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				scores[i][0] = f;
				scores[i][1] = s;
			}
			
			Arrays.sort(scores, (o1, o2) -> o1[0]-o2[0]);
			int rating = scores[0][1];
			for(int i = 1; i < N; i++) {
				if (scores[i][1] < rating) {
					res++;
					rating = scores[i][1];
				}
			}
			

			System.out.println(res);
		}

	}

}
