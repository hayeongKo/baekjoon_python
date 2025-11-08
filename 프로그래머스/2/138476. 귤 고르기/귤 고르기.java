import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Integer[] size = new Integer[10_000_001];
        Arrays.fill(size, 0);
        
        for(int t : tangerine) size[t]++;
        Arrays.sort(size, (a, b) -> b-a);
        
        int answer = 0;
        for(int i = 0; i < 10_000_001; i++) {
            k-=size[i];
            answer++;
            if (k <= 0) break;
        }
        return answer;
    }
}