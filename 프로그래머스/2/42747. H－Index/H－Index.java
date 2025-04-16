import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int low = -1;
        int high = citations.length+1;
    
        while(low < high-1) {
            int mid = (low + high) / 2;
            if (f(mid, citations) < mid) {
                high = mid;
            } else {
                low = mid;
            }
        }
        
        return low;
    }
    
    // h번 이상 인용된 논문 수
    public static int f(int h, int[] citations) {
        int cnt = 0;
        for(int c : citations) {
            if (c >= h) cnt++;
        }
        return cnt;
    }
}