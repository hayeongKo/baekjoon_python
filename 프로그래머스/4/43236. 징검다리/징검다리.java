import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        int answer = 0;
        
        while(left <= right) {
            int mid = (left+right)/2;
            if (removeable(distance, rocks, n, mid)) {
                answer = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return answer;
    }
    
    public boolean removeable(int distance, int[] rocks, int n, int mid) {
        int removed = 0;
        int prev = 0;
        
        for(int rock : rocks) {
            if (rock - prev < mid) { // 만약 이전 돌과 해당 돌의 거리가 mid가 작다면
                removed++; // 돌 제거
                if (removed > n) return false; // 너무 많이 부셔야 됨
            } else {
                prev = rock; // 돌 제거 안함
            }
        }
        
        // 마지막 도착점과도 확인
        if (distance - prev < mid) {
            removed++;
        }
        
        return removed <= n;
    }
}