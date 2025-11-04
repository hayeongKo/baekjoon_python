import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> houses;
    static int N, C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        houses = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            houses.add(Integer.parseInt(br.readLine()));
        }

        houses.sort(Comparator.naturalOrder());

        long left = 1;
        long right = houses.get(N-1);
        long ans = 0;

        while(left <= right) {
            long mid = (left+right)/2;
            if (check(mid)) {
                ans = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(ans);
    }

    public static boolean check(long dist) {
        int cnt = 1;
        int start = 0;
        int next = 1;
        while(next < N) {
            if (houses.get(next)-houses.get(start) >= dist) {
                cnt++;
                if (cnt >= C) return true;;
                start = next;
            }
            next++;
        }
        return false;
    }
}
