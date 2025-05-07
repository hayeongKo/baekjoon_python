import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static String[] s;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> aeiou = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        L = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);
        aeiou.add("a");
        aeiou.add("e");
        aeiou.add("i");
        aeiou.add("o");
        aeiou.add("u");

        s = br.readLine().split(" ");
        visited = new boolean[C];
        Arrays.sort(s);
        
        dfs(0, 0, 0, 0);
        System.out.println(sb.toString());
    }

    public static void dfs(int depth, int idx, int cnt1, int cnt2) {

        if (depth == L && cnt1 >= 1 && cnt2 >= 2) {
            for(int i = 0; i < C; i++) {
                if (visited[i]) sb.append(s[i]);
            }
            sb.append("\n");
            return;
        }

        for(int i = idx; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;

                if (aeiou.contains(s[i])) cnt1++;
                else cnt2++;

                dfs(depth+1, i+1, cnt1, cnt2);

                if (aeiou.contains(s[i])) cnt1--;
                else cnt2--;

                visited[i] = false;
            }
        }
    }
}