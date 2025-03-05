import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        String[] inputs;
        for(int i = 0; i < N; i++) {
            inputs = br.readLine().split("\\.");
            String file = inputs[1];
            if (map.containsKey(file)) {
                map.replace(file, map.get(file)+1);
            } else {
                map.put(file, 1);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for(String key : keySet) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
