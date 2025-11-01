import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            int cur = numbers[i];
            // System.out.println("cur: " + cur + " " + q.toString());
            while(!q.isEmpty() && numbers[q.peekLast()] < cur) {
                answer[q.pollLast()]=cur;
            }
            q.offer(i);
        }
        
        while(!q.isEmpty()) answer[q.poll()]=-1;
        return answer;
    }
}