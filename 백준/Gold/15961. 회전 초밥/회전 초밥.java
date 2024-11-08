// 15961
// 회전 초밥

import java.io.*;
import java.util.*;

public class Main {
    static int N, d, k, c;
    static int[] sushi;
    static HashSet<Integer> edible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        d = Integer.parseInt(inputs[1]);
        k = Integer.parseInt(inputs[2]);
        c = Integer.parseInt(inputs[3]);

        sushi = new int[N];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] sushiCnt = new int[d+1];
        int nCnt = 0; // 현재 고유한 초밥 갯수
        int res = 0;

        for (int i = 0; i < k; i++) {
            if (sushiCnt[sushi[i]] == 0) {// 아직 같은 종류의 초밥을 먹지 않았다면
                nCnt++;
            }
            sushiCnt[sushi[i]]++;
        }

        res = nCnt;

        for (int i = 0; i < N; i++) {
            int newSushi = sushi[(i+k)%N];
            if (sushiCnt[newSushi] == 0) {
                nCnt++;
            }
            sushiCnt[newSushi]++;

            int prevSushi = sushi[i];
            sushiCnt[prevSushi]--;
            if (sushiCnt[prevSushi] == 0) {
                nCnt--;
            }

            if (sushiCnt[c] == 0) { // 초밥 쿠폰
                res = Math.max(nCnt+1, res);
            } else {
                res = Math.max(nCnt, res);
            }
        }
        System.out.println(res);
    }
}