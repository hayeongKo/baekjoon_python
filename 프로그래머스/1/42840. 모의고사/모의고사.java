import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] score = new int[3];
        for(int i = 0; i < answers.length; i++) {
            if (answers[i] == s1[i%5]) score[0]++;
            if (answers[i] == s2[i%8]) score[1]++;
            if (answers[i] == s3[i%10]) score[2]++;
        }
        
        int max = 0;
        for(int s:score) {
            max = Math.max(s, max);
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < score.length; i++) {
            if(score[i] == max) ans.add(i+1);
        }
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
        
    }
}