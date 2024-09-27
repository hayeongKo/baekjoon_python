import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0;
        int zero_cnt = 0;
        
        Set<Integer> winNums = Arrays.stream(win_nums)
            .boxed()
            .collect(Collectors.toSet());
    
        for(int lotto : lottos) {
            if(winNums.contains(lotto)) {
                cnt++;
            } else if(lotto == 0) {
                zero_cnt++;
            }
        }
        
        int[] answer = new int[2];
        if(cnt == 0 && zero_cnt == 0) {
            answer[0] = 6;
        } else {
            answer[0] = 7 - (cnt+zero_cnt);
        }
        
        if(cnt == 0) {
            answer[1] = 6;
        } else {
            answer[1] = 7 - cnt;
        }
        return answer;
        
    }
}