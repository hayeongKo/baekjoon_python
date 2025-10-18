import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder check = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if (check.length()<bomb.length()) {
                check.append(s.charAt(i));
            } else {
                sb.append(check.charAt(0));
                check.deleteCharAt(0);
                check.append(s.charAt(i));
            }

            // System.out.println("sb: " + sb.toString() + " check: " + check.toString());

            if (check.toString().equals(bomb)) {
                check = new StringBuilder();
                if (sb.length()==0) continue;
                // System.out.println(sb.substring(sb.length()-bomb.length()+1));
                check.append(sb.substring(Math.max(sb.length()-bomb.length(), 0)));
                sb.delete(Math.max(sb.length()-bomb.length(), 0), sb.length());
            }
        }

        sb.append(check);

        if (sb.length()==0) {
            System.out.println("FRULA");
        } else System.out.println(sb.toString());
    }
}
