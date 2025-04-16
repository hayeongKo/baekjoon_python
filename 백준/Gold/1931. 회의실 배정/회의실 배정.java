import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> schedule = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int[] tmp = new int[2];
            tmp[0] = Integer.parseInt(inputs[0]);
            tmp[1] = Integer.parseInt(inputs[1]);
            schedule.add(tmp);
        }

        schedule.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });
        
        int answer = 0;
        int end = 0;
        for(int[] s : schedule) {
            if (end <= s[0]) {
                end = s[1];
                answer++;
            }
        }

        System.out.println(answer);
    }
}