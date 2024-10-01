// 12933
// 오리

import java.io.*;
import java.util.*;;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("");
        int[] cnt = new int[5]; // q = 0, u = 1, a = 2, c = 3, k = 4

        int temp = 0;
        int answer = 0;

        for(String spell : inputs) {
            if (spell.equals("q")) {
                cnt[0]++;
                temp++;
                answer = Math.max(answer, temp);
            } else if (spell.equals("u")) {
                if(cnt[0] > cnt[1]) {
                    cnt[1]++;
                } else {
                    System.out.println(-1);
                    return;
                }
            } else if(spell.equals("a")) {
                if(cnt[1] > cnt[2]) {
                    cnt[2]++;
                } else {
                    System.out.println(-1);
                    return;
                }
            } else if (spell.equals("c")) {
                if(cnt[2] > cnt[3]) {
                    cnt[3]++;
                } else {
                    System.out.println(-1);
                    return;
                }
            } else if (spell.equals("k")) {
                if(cnt[3] > cnt[4]) {
                    cnt[4]++;
                    temp--;
                } else {
                    System.out.println(-1);
                    return;
                }
            }
        }

        if (cnt[0] == cnt[1] && cnt[1] == cnt[2] && cnt[2] == cnt[3] && cnt[3] == cnt[4]) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}
