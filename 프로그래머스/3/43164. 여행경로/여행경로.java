import java.util.*;

class Solution {
    List<String> answer;
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        Arrays.sort(tickets, (a, b) -> {
            int cmp = a[0].compareTo(b[0]);
            if (cmp == 0) {
                return a[1].compareTo(b[1]);
            }
            return cmp;
        });
        
        dfs(tickets, path);
        return answer.toArray(new String[0]);
        
    }
    
    public boolean dfs(String[][] tickets, List<String> path) {
        if (path.size() == tickets.length+1) {
            answer = new ArrayList<>(path);
            return true;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if (!visited[i] && path.get(path.size()-1).equals(tickets[i][0])) {
                visited[i] = true;
                path.add(tickets[i][1]);
                if (dfs(tickets, path)) return true;
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }
        
        return false;
    }
}