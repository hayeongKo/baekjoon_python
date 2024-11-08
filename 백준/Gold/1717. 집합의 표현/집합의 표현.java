// 1717
// 집합의 표현

import java.io.*;

public class Main {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        parent = new int[n+1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int command = Integer.parseInt(inputs[0]);
            int a = Integer.parseInt(inputs[1]);
            int b = Integer.parseInt(inputs[2]);

            if (command == 0) { // 합집합
                union(a, b);
            } else if (command == 1) { // 두 원소가 같은 집합에 포함
                if (findParent(a) == findParent(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a<b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}