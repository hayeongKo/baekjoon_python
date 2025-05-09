import java.util.*;

class Solution {
    boolean[] visited;
    int N;
    List<String> ans;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            int cmp = a[0].compareTo(b[0]);
            if (cmp == 0) return a[1].compareTo(b[1]);
            return cmp;
        });
        
        N = tickets.length;
        ans = new ArrayList<>();
        visited = new boolean[N];
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs(tickets, path);
        return ans.toArray(new String[0]);
    }
    
    public boolean dfs(String[][] tickets, List<String> path) {
        if (path.size() == N+1) {
            ans = new ArrayList<>(path);
            return true;
        }
        
        for(int i = 0; i < N; i++) {
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