import java.io.*;
import java.util.*;

public class Main {
    static int[] heights, diffs;
    static int N, K;
    static PriorityQueue<int[]> pq;
    static int[] parent;
    static int unionCnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        unionCnt = 0;
        heights = new int[N];
        diffs = new int[N-1]; // 여기만 N-1로 수정
        parent = new int[N];
        pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            parent[i] = i;
            heights[i] = Integer.parseInt(st.nextToken());
            if (i == 0) continue;
            diffs[i-1] = heights[i] - heights[i-1]; // 인덱스 수정
            pq.offer(new int[]{diffs[i-1], i-1, i}); // 인덱스 수정
        }

        while(!pq.isEmpty()) {
            if (N - unionCnt == K) break;

            int[] cur = pq.poll();
            int s = cur[1];
            int e = cur[2];

            // 여기 수정: find()로 루트 확인
            if (find(s) == find(e)) continue;
            
            union(s, e);
        }

        int ans = 0;
        int team = find(0);
        int sh = heights[0];
        int lh = -1;
        int i = 0;

        while(true) {
            if (i==N) break;
            if (team == find(i)) {
                lh = heights[i++];
                continue;
            } else {
                ans+=(lh-sh);
                team = find(i);
                sh = heights[i];
            }
        }

        ans+=(lh-sh);

        System.out.println(ans);

    }

    public static int find(int n) {
        if (parent[n]!=n) {
            parent[n]=find(parent[n]);
        }
        return parent[n];
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a==b) return;
        unionCnt++;

        if (a<b) {
            parent[b]=a;
        } else {
            parent[a]=b;
        }
    }
}
