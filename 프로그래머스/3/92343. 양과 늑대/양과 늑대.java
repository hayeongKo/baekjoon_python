import java.util.*;

class Solution {
    int[] ds = {1, 0};
    int[] dw = {0, 1};
    
    class State {
        int n, s, w;
        long v;
        State(int n, int s, int w, long v) {
            this.n = n;
            this.s = s;
            this.w = w;
            this.v = v;
        }
    }
    public int solution(int[] info, int[][] edges) {
        int N = info.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();
        
        for(int i = 0; i < N; i++) graph.put(i, new ArrayList<>());
        
        for(int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        
        Queue<State> q = new ArrayDeque<>(); // 현재 노드, 양 개수, 늑대 개수
        q.offer(new State(0, 1, 0, 1 << 0));
        visited.add("0 1 0 " + (1<<0));
        
        int ans = 0;
        
        while(!q.isEmpty()) {
            State cur = q.poll();
            int cn = cur.n;
            int sheep = cur.s;
            int wolf = cur.w;
            long counted = cur.v;
            
            ans = Math.max(ans, sheep);
            
            for(int next : graph.get(cn)) {
                int ns = sheep;
                int nw = wolf;
                
                if ((counted & (1<<next)) == 0) {
                    ns+=ds[info[next]];
                    nw+=dw[info[next]];
                }
                
                String key = next+" "+ns+" "+nw+" "+(counted|(1L<<next));
                if (visited.contains(key)) continue;
                visited.add(key);
                
                if (ns > nw) {
                    q.offer(new State(next, ns, nw, counted|(1 << next)));
                }
            }
        }
        
        return ans;
    }
}