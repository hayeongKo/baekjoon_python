import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        int n = id_list.length;
        boolean[][] table = new boolean[n][n];
        List<Integer> stop = new ArrayList<>();
        
        for(String report : reports) {
            String[] temps = report.split(" ");
            int user = Arrays.asList(id_list).indexOf(temps[0]);
            int reported = Arrays.asList(id_list).indexOf(temps[1]);
            
            table[user][reported] = true; // 동일 유저가 같은 사람을 여러번 신고해도 1번으로 체크
        }
        
        
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(table[j][i]) cnt++;
            }
            
            if(cnt >= k) stop.add(i);
        }
        
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            int res = 0;
            for(Integer id : stop) {
                if(table[i][id]) res++;
            }
            answer[i] = res;
        }
        return answer;
    }
}