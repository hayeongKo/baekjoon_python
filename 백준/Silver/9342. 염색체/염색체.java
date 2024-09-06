// 9342
// 염색체

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            Set<String> set = new LinkedHashSet<>(Arrays.asList(br.readLine().split("")));
            String output = String.join("", set);
            
            if (output.matches("[A-F]?AFC[A-F]?")) {
                System.out.println("Infected!");
            } else {
                System.out.println("Good");
            }
        }
    }
}