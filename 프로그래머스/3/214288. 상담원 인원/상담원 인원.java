import java.util.*;

class Solution {
    int[][] dp;
    int n, k, answer;
    List<int[]>[] consulting;
    public int solution(int k, int n, int[][] reqs) {
        answer = Integer.MAX_VALUE;
        this.k = k;
        this.n = n;
        
        consulting = new ArrayList[k+1];
        for(int i = 1; i <= k; i++) consulting[i] = new ArrayList<>();
        
        int[][] dp = new int[k+1][n+1];
        boolean[][] visited = new boolean[k+1][n+1];
        for(int[] req : reqs) {
            int type = req[2];
            int s = req[0];
            int e = req[0]+req[1];
            int c = req[1];
            consulting[type].add(new int[]{s, e, c});
        }
        
        dfs(1, n, new ArrayList<>());
        return answer;
    }
    
    public void dfs(int depth, int remain, List<Integer> consultants) {
        if (depth == k+1) {
            if (remain != 0) return;
            answer = Math.min(answer, calculate(consultants));
            return;
        }
        
        for(int i = 1; i <= remain-(k-depth); i++) {
            consultants.add(i);
            dfs(depth+1, remain-i, consultants);
            consultants.remove(consultants.size()-1);
        }
    }
    
    public int calculate(List<Integer> consultants) {
        int res = 0;
        for(int type = 1; type <= k; type++) {
            int msize = consultants.get(type-1);
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
            
            for(int[] c : consulting[type]) {
                int start = c[0];
                int end = c[1];
                while(!pq.isEmpty() && pq.peek() <= start) {
                    pq.poll();
                }
                
                if (pq.size() >= msize) {
                    int endTime = pq.poll();
                    res += (endTime-start);
                    pq.offer(endTime+c[2]);
                } else {
                    pq.offer(end);
                }

            }
        }
        return res;
    }
}