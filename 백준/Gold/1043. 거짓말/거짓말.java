import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] parent, truthPeople;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i = 1; i <= N; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        truthPeople = new int[truthCount];
        for(int i = 0; i < truthCount; i++) {
            truthPeople[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < truthCount; i++) {
            union(truthPeople[0], truthPeople[i]);
        }

        List<int[]> parties = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] party = new int[num];
            party[0] = Integer.parseInt(st.nextToken());
            for(int j = 1; j < num; j++) {
                party[j] = Integer.parseInt(st.nextToken());
                union(party[0], party[j]);
            }
            parties.add(party);
        }

        int ans = 0;
        for(int[] party : parties) {
            boolean flag = true;
            for(int p : party) {
                for(int t : truthPeople) {
                    if (find(p) == find(t)) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) break;
            }
            if (flag) ans++;
        }

        System.out.println(ans);
    }

    public static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        } 
        return parent[a];
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[b] = a; 
    } 
}
