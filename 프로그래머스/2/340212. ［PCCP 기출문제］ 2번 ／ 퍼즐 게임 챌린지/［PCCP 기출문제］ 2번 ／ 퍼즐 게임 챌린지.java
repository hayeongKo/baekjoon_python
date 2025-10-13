import java.util.*;

class Solution {
    int n;
    public int solution(int[] diffs, int[] times, long limit) {
        int ans = 0;
        this.n = diffs.length;
        
        int maxLevel = 0;
        
        for(int i = 0; i < diffs.length; i++) {
            maxLevel = Math.max(maxLevel, diffs[i]);
        }
        
        int left = 1;
        int right = maxLevel;
        
        while(left <= right) {
            // System.out.println("left: " + left+" right: " + right);
            int mid = (left+right)/2;
            long res = solve(diffs, times, limit, mid);
            if (res < limit) {
                ans = mid;
                right = mid-1;
            } else if (res > limit){
                left = mid+1;
            } else {
                return mid;
            }
        }

        return ans;
    }
    
    public long solve(int[] diffs, int[] times, long limit, int level) {
        long total = 0;
        for(int i = 0; i < n; i++) {
            if (diffs[i] <= level) {
                total+=times[i];
            } else {
                total+=(diffs[i]-level)*(times[i-1]+times[i])+times[i];
            }
            if (total > limit) break;
        }
        
        return total;
    }
}