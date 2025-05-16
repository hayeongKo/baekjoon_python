import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = 0;
        
        for(int t : times) {
            right = Math.max(right, t);
        }
        
        right *= n;
        
        long answer = right;
        
        while(left <= right) {
            long mid = (left+right) / 2;
            long cnt = 0;
            
            for(int time : times) {
                cnt += mid / time;
            }
            
            if (cnt >= n) {
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        
        return answer;
    }
}