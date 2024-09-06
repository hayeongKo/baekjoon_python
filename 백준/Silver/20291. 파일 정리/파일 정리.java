// 20291
// 파일 정리

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split("\\.");

            if (map.containsKey(inputs[1])) {
                map.replace(inputs[1], map.get(inputs[1]) + 1);
            } else {
                map.put(inputs[1], 1);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet);

        for (String key : keySet) {
            System.out.println(key + " " + map.get(key));
        }
    }
}