import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
		for(int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		long ans = 0;
		while(pq.size() != 1) {
			int res = pq.poll()+pq.poll();
			ans+=res;
			pq.offer(res);
		}
		
		System.out.println(ans);
	}
}
