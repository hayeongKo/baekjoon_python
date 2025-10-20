import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        Map<Character, Node> childNodes = new HashMap<>();
        boolean end;
    }

    static class Trie {
        Node root = new Node();

        boolean insert(String numbers) {
            Node node = this.root;
            for(char n : numbers.toCharArray()) {
                node = node.childNodes.computeIfAbsent(n, key -> new Node());
                if (node.end) return false;
            }
            node.end=true;
            return true;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            Trie trie = new Trie();
            int N = Integer.parseInt(br.readLine());
            boolean flag = false;
            List<String> numbers = new ArrayList<>();
            while(N-->0) {
                numbers.add(br.readLine());
            }
            numbers.sort(Comparator.naturalOrder());
            for(String number : numbers) {
                if (!trie.insert(number)) {
                    flag=true;
                    break;
                }
            } 
            System.out.println(!flag ? "YES" : "NO");
        }
    }
}
