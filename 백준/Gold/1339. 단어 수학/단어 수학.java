import java.util.*;
import java.io.*;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Integer[] visited = new Integer[26];
		for(int i = 0; i < visited.length; i++) visited[i] = 0;
		
		for(int k = 0; k < N; k++) {
			String s = br.readLine();
			int step=s.length()-1;
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				visited[c-'A']+= (int) Math.pow(10, step-i);
			}
		}
		
		long ans = 0;
		
		Arrays.sort(visited, (a, b) -> b-a);
		for(int i = 0; i < 26; i++) {
			if (visited[i] == 0) break;
			ans += (9-i)*visited[i];
		}
		
		System.out.println(ans);

	}

}
