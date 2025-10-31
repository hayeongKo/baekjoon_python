class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        
        int[] ans = new int[]{0, n};
        
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        
        while(end < n) {
            if (sum == k) {
                if (ans[1]-ans[0]>end-start) {
                    ans = new int[]{start, end};
                }
                sum -= sequence[start];
                start++;
                if (start == n-1) break;
            } else if (sum < k) {
                end++;
                if (end < n) sum += sequence[end];
            } else {
                sum -= sequence[start];
                start++;
            }
            
        }
        
        return ans;
    }
}