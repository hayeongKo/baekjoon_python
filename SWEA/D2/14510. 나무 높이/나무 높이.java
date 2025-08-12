import java.io.*;
import java.util.*;

public class Solution {
	static int[] dp;
	static int[] height;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int maxH = 0;
			int n = Integer.parseInt(br.readLine());
			height = new int[n];
			int sum = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < n; i++) {
				height[i] = Integer.parseInt(st.nextToken());
				if (height[i] > maxH) maxH = height[i];
			}
			
			int odd = 0;
			int even = 0;
			for(int i = 0; i < n; i++) {
				sum += (maxH-height[i]);
				if ((maxH-height[i])%2==1) odd++;
				even+=(maxH-height[i])/2;
			}
			
			int ans = 0;
			if (odd > even) {
				ans = odd*2-1;
			} else {
				ans = (sum/3)*2+sum%3;
			}
			sb.append("#"+t+" "+ans+"\n");
		}
		System.out.println(sb.toString());
	}

}
