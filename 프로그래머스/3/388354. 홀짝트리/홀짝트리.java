import java.util.*;

class Solution {
    Map<Integer, List<Integer>> graph;
    
    public int[] solution(int[] nodes, int[][] edges) {
        graph = new HashMap<>();
        for(int node : nodes) {
            graph.put(node, new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        int[] ans = new int[2];
        
        for(int root : nodes) {
            if (visited.contains(root)) continue;
            
            int sameCnt = 0;
            int diffCnt = 0;
            
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(root);
            visited.add(root);
            
            while(!q.isEmpty()) {
                int cur = q.poll();
                
                if (cur%2==graph.get(cur).size()%2) sameCnt++;
                else diffCnt++;
                
                for(int next : graph.get(cur)) {
                    if (visited.contains(next)) continue;
                    q.offer(next);
                    visited.add(next);
                }
            }
            
            if (sameCnt==1) ans[0]++;
            if (diffCnt==1) ans[1]++;
        }
        
        return ans;
    }
}