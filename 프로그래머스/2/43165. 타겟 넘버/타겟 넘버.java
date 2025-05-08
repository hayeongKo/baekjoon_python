import java.util.*;

class Solution {
    static int ans;
    public int solution(int[] numbers, int target) {
        ans = 0;
        dfs(numbers, target, 0, 0, 0);
        return ans;
    }
    
    public void dfs(int[] nums, int target, int depth, int value, int idx) {
        if (depth == nums.length) {
            if (target == value) ans++;
            return;
        }
        
        for(int i = idx; i < nums.length; i++) {
            dfs(nums, target, depth+1, value+nums[i], i+1);
            dfs(nums, target, depth+1, value-nums[i], i+1);
        }
    }
}