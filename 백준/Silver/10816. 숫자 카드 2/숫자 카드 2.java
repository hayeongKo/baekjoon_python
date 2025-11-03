import java.util.*;
import java.io.*;

public class Main {
    static int N, L;
    static List<Integer> nums;
    static Map<Integer, Integer> cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            cnt.put(k, cnt.getOrDefault(k, 0)+1);
        }
        nums = new ArrayList<>(cnt.keySet());
        nums.sort(Comparator.naturalOrder());
        L = nums.size();

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(cnt.getOrDefault(target, 0)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
