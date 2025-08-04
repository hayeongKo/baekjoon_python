import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        
        for(int i = 1; i <= N; i++) parent[i] = i;

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) union(i, j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        boolean flag = true;
        for(int i = 1; i < M; i++) {
            int e = Integer.parseInt(st.nextToken());
            if (find(s) != find(e)) {
                flag = false;
                break;
            }
            s = e;
        }
        System.out.println(flag ? "YES" : "NO");

    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a > b) parent[a] = b;
        else parent[b] = a;
    }

    public static int find(int n) {
        if (parent[n] != n) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }
}
