import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> o1[1]-o2[1]);
        
        int ans = 0;
        int shot = -1;
        
        for(int[] target : targets) {
            if (target[0] >= shot) {
                shot = target[1];
                ans++;
            }
        }

        return ans;
    }
}