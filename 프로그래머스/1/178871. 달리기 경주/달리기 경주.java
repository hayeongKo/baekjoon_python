import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] answer = new String[players.length];
        
        int index = 0;
        for(String player : players) {
            map.put(player, index);
            answer[index] = player;
            index++;
        }
    
        
        for(String call : callings) {
            String temp = "";
            
            int j = map.get(call);
            temp = answer[j-1];
            map.replace(call, j, j-1);
            map.replace(temp, j-1, j);
            answer[j-1] = call;
            answer[j] = temp;
        }
        
        return answer;
    }
}