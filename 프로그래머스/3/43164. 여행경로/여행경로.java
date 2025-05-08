import java.util.*;

class Solution {
    boolean[] visited;
    int N;
    List<String> answer = null;
    
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        visited = new boolean[N];
        
        Arrays.sort(tickets, (o1, o2) -> {
            int cmp = o1[0].compareTo(o2[0]);
            if (cmp == 0) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });
        
        
        List<String> list = new ArrayList<>();
        list.add("ICN");
        dfs(tickets, 0, list);
        
        return answer.toArray(new String[0]);
    }
    
    public boolean dfs(String[][] tickets, int depth, List<String> trip) {
        if (depth == N) {
            answer = new ArrayList<>(trip);
            return true;
        }
        
        for(int i = 0; i < N; i++) {
            if (!visited[i] && trip.get(trip.size()-1).equals(tickets[i][0])) {
                visited[i] = true;
                trip.add(tickets[i][1]);
                if (dfs(tickets, depth+1, trip)) return true;
                trip.remove(trip.size()-1);
                visited[i] = false;
            }
        }
        return false;
    }
}