import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dist = new int[N];
		int[] cost = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N-1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		long ans = 0;
		int step = 0;
		long distance = 0;
		long curCost = cost[0];

		while(true) {
			if (step == N-1) {
				ans += distance*curCost;
				break;
			}
			
			if (curCost > cost[step]) {
				ans += distance*curCost;
				distance = 0;
				curCost = cost[step];
			} else {
				distance += dist[step++];
			}
		}
		
		System.out.println(ans);

	}

}
