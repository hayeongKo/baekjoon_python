// 2477
// 참외밭

import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int d, len;
        Node(int d, int len) {
            this.d = d;
            this.len = len;
        }
    }
    static int m, w, h, mw, mh;
    static List<Node> sides;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        sides = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            String[] inputs = br.readLine().split(" ");
            sides.add(new Node(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
        }

        while(true) {
            StringBuilder sb = new StringBuilder("");
            for(Node node:sides) {
                sb.append(node.d);
            }
            
            String temp = sb.toString();

            if (temp.equals("323142") || temp.equals("131423") || temp.equals("414231") || temp.equals("242314")) {
                mh = sides.get(0).len;
                mw = sides.get(1).len;
                h = sides.get(4).len;
                w = sides.get(3).len;
                break;
            }
            sides.add(sides.get(0));
            sides.remove(0);
        }
        System.out.println((h*w-mh*mw)*m);
    }
}