import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int j = 0; j < commands.length; j++) {
            int start = commands[j][0];
            int end = commands[j][1];
            int k = commands[j][2];
            
            List<Integer> list = new ArrayList<>();
            for(int i = start-1; i < end; i++) {
                list.add(array[i]);
            }
            list.sort(Comparator.naturalOrder());
            answer[j] = list.get(k-1);
        }
        
        return answer;
    }
}