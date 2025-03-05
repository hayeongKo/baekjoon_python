import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        boolean tagFlag = false;
        ArrayDeque<Character> q = new ArrayDeque<>();

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '<') {
                while(!q.isEmpty()) System.out.print(q.pollLast());
                tagFlag = true;
                System.out.print(c);
            } else if (c == '>') {
                tagFlag = false;
                System.out.print(c);
            } else {
                if (tagFlag) System.out.print(c);
                else {
                    if (c == ' ') {
                        while(!q.isEmpty()) System.out.print(q.pollLast());
                        System.out.print(" ");
                    } else {
                        q.offer(c);
                    }
                }
            }
            
        }

        while (!q.isEmpty()) System.out.print(q.pollLast());
    }
}