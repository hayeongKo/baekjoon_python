import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		// 양수, 음수 각각 pq 만들어서 진
		PriorityQueue<Integer> positive = new PriorityQueue<>(Comparator.reverseOrder()); // 큰 수 -> 작은 수
		PriorityQueue<Integer> negative = new PriorityQueue<>(Comparator.naturalOrder()); // (절대값) 큰 수 -> 작은 수
		int zero = 0;
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n > 0) positive.offer(n);
			else if (n==0) zero++;
			else negative.offer(n);
		}
		
		long ans = 0;
		
		// 양수끼리
		while(positive.size() >= 2) {
			int a = positive.poll();
			int b = positive.poll();
			if (a*b < a+b) { // 곱하기보다 더하는게 이득일 때
				positive.offer(a);
				positive.offer(b);
				break;
			} else {
				ans+=a*b;
			}
		}
		
		
		// 음수끼리 -> 곱해서 양수로 만드는 게 이득
		while(negative.size() >= 2) {
			ans+=negative.poll()*negative.poll();
		}
		
		// 음수가 남아있을 경우 -> 0을 곱해서 0으로 만드는 게 이득
		while(true) {
			if (negative.isEmpty() || zero == 0) break;
			zero--;
			negative.poll();
		}
		
		while(!negative.isEmpty()) ans += negative.poll();
		while (!positive.isEmpty()) ans += positive.poll();

		System.out.println(ans);

	}

}
