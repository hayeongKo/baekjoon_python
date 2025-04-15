import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int t = 0; t < T; t++) {
            long n = Long.parseLong(br.readLine());
            if (n == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(n);
            }
        }
    }
}