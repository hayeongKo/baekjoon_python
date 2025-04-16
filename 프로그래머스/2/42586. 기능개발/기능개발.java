import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int N = progresses.length;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            queue.offer((int)Math.ceil((double)(100-progresses[i])/(double)speeds[i]));
        }
        
        
        while(!queue.isEmpty()) {
            int cnt = 1;
            int now = queue.pop();
            while(!queue.isEmpty()) {
                int tmp = queue.peek();
                if (now >= tmp) {
                    queue.poll();
                    cnt++;
                } else {
                    break;
                }
            }
            list.add(cnt);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}