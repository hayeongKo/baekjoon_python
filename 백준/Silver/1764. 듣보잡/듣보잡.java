// 1764
// 듣보잡

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLst = br.readLine().split(" ");

        int n = Integer.parseInt(inputLst[0]);
        int m = Integer.parseInt(inputLst[1]);

        HashSet<String> listeners = new HashSet<>();
        List<String> answer = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            listeners.add(br.readLine());
        }

        for(int i = 0; i < m; i++) {
            String looker = br.readLine();
            if (listeners.contains(looker)) {
                answer.add(looker);
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        for (String name:answer) {
            System.out.println(name);
        }
    }
}