import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photos) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        int[] result = new int[photos.length];
        int j = 0;
        for(String[] photo : photos) {
            int score = 0;
            for(String person : photo) {
                if (map.containsKey(person)) score += map.get(person);
            }
            result[j++] = score;
        }
        return result;
    }
}