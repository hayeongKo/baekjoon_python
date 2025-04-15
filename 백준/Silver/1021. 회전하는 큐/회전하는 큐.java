import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        inputs = br.readLine().split(" ");
        int ans = 0;

        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(inputs[i]);
            int diff = 0;

            for(int num : queue) {
                if (num == target) {
                    if (diff > queue.size() - diff) {
                        diff = -1*(queue.size()-diff);
                    }
                    break;
                } else {
                    diff++;
                }
            }

            if (diff < 0) {
                for(int j = 0; j < Math.abs(diff); j++) {
                    queue.offerFirst(queue.pollLast());
                    ans++;
                }
            } else if (diff > 0) {
                for(int j = 0; j < diff; j++) {
                    queue.offer(queue.pop());
                    ans++;
                }
            }

            queue.poll();
        }

        System.out.println(ans);
    }
}