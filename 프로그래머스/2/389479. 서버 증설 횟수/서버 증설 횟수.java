import java.util.*;

class Solution {
    Deque<int[]> servers;
    int existCnt = 0;
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int t = 0;
        
        servers = new ArrayDeque<>();
        for(int p : players) {
            int needCnt = p/m;
            
            if (checkServer(t) < needCnt) {
                servers.offer(new int[]{t+k-1, needCnt-existCnt});
                answer+=needCnt-existCnt;
                existCnt+=needCnt-existCnt;
            }
            
            System.out.println("t: " + t + " exist: "  + existCnt + " answer : " + answer);
            
            t++;
        }
        
        return answer;
    }
    
    public int checkServer(int now) {
        while(!servers.isEmpty()) {
            if (servers.peek()[0] < now) {
                existCnt -= servers.poll()[1];
            } else break;
        }
        return existCnt;
    }
}