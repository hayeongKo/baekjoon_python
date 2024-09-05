// 17413
// 단어 뒤집기 2

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");

        // for (String i : input) {
        //     System.out.println(i);
        // }

        List<String> tag = new ArrayList<>();
        Deque<String> temp = new ArrayDeque<>();
        boolean flag = false;

        for (String spell : input) {
            if (spell.equals("<")) {
                while (!temp.isEmpty()) {
                    System.out.print(temp.pollLast());
                }
                tag.add(spell);
                flag = true;
            } else if (spell.equals(">")) {
                tag.add(spell);
                System.out.print(String.join("", tag)); // ''.join(list) 랑 똑같은거
                tag.clear();
                flag = false;
            } else if (flag) {
                tag.add(spell);
            } else if (spell.equals(" ")) {
                while (!temp.isEmpty()) {
                    System.out.print(temp.pollLast());
                }
                System.out.print(" ");
            } else {
                temp.add(spell);
            }
        }

        while (!temp.isEmpty()) {
            System.out.print(temp.pollLast());
        }

    }
}