import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 최대한 다양한 초밥
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for(int i = 0; i < N; i++) {
            sushi[i]=Integer.parseInt(br.readLine());
        }

        int[] type = new int[d+1];
        int res = 0;
        // 초기 윈도우
        for (int i = 0; i < k; i++) {
            if (type[sushi[i]] == 0) res++;
            type[sushi[i]]++;
        }

        int ans = res;
        // 쿠폰 초밥 고려
        if (type[c] == 0) ans++;

        // 슬라이딩 윈도우 이동
        int start = 0;
        for (int i = 0; i < N - 1; i++) {
            // 왼쪽 제거
            type[sushi[start]]--;
            if (type[sushi[start]] == 0) res--;
            start = (start + 1) % N;

            // 오른쪽 추가
            int next = (start + k - 1) % N;
            if (type[sushi[next]] == 0) res++;
            type[sushi[next]]++;

            // 쿠폰 포함 최대값 갱신
            ans = Math.max(ans, type[c] == 0 ? res + 1 : res);
        }
        System.out.println(ans);
        
    }
}
