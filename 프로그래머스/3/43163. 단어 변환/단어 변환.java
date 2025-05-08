import java.util.*;

class Solution {
    class State {
        String word;
        int cnt;
        State(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }
    
    public int bfs(String begin, String target, String[] words) {
        ArrayDeque<State> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(new State(begin, 0));
        
        while(!queue.isEmpty()) {
            State now = queue.pop();
            if (target.equals(now.word)) return now.cnt;
            
            for(int i = 0; i < words.length; i++) {
                if (!visited[i] && changable(now.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new State(words[i], now.cnt+1));
                }
            } 
        }
        
        return 0;
    }
    
    public boolean changable(String a, String b) {
        int cnt = 0;
        for(int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
            if (cnt > 1) return false;
        }
        
        if (cnt == 0) return false;
        return true;
    }
}