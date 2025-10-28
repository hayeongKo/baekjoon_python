import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            String str = br.readLine();
            int N = str.length();
            int K = Integer.parseInt(br.readLine());
            int[] cnt = new int[26];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < N; i++) {
                char c = str.charAt(i);
                int idx = c-'a';
                cnt[idx]++;
                int start = i;
                
                if (cnt[idx]>=K) {
                    // 어떤 문자를 정확히 K개 포함하는 가장 짧은 연속 문자열의 길이
                    int ccnt = K;
                    while(true) {
                        if (str.charAt(start) == c) {
                            ccnt--;
                        }

                        if (ccnt == 0) break;
                        start--;
                    }
                    // System.out.println(start+" "+i);
                    min = Math.min(i-start+1, min);
                    max = Math.max(i-start+1, max);
                }   
            }
            
            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(min+" "+max).append("\n");
            }
        }
        // System.out.println("-------------");
        System.out.println(sb.toString());
    }
}
