// 15787
// 기차가 어둠을 헤치고 은하수를

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] trains;
    static HashSet<Integer> answer = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        trains = new int[N+1];

        for(int t = 0; t < M; t++) {
            inputs = br.readLine().split(" ");
            int command = Integer.parseInt(inputs[0]);
            int i = Integer.parseInt(inputs[1]);
            int x = 0;
            if (command < 3) {
                x = Integer.parseInt(inputs[2]);
            }
            command(command, i, x-1);
        }

        for(int i = 1; i <= N; i++) {
            answer.add(trains[i]);
        }

        System.out.println(answer.size());
    }

    public static void command(int command, int i, int x) {
        // 좌석에 사람 태우기
        if (command == 1) {
            trains[i] |= (1 << x);
        // 하차
        } else if(command == 2) {
            trains[i] &= ~(1 << x);
        // 한칸씩 뒤로
        } else if(command == 3) {
            trains[i] <<= 1;
            trains[i] &= ((1 << 20)-1); // 20칸까지만 유지
        // 한칸씩 앞으로
        } else if(command == 4) {
            trains[i] >>= 1;
        }
    }
}
