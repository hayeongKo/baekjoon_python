// 17609
// 회문

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            List<String> inputs = new ArrayList<>(Arrays.asList(br.readLine().split("")));
            if (!isSymmetrical(inputs)) {
                isPalindrome(inputs);
            } else {
                System.out.println(0);
            }
        }
    }

    public static void isPalindrome(List<String> inputs) {
        for(int j = 0; j < inputs.size()/2; j++) {
            //유사회문
            if (!inputs.get(j).equals(inputs.get(inputs.size()-1-j))) {
                List<String> temp = new ArrayList<>(inputs.subList(j, inputs.size()-j));
                
                if (isSymmetrical(temp.subList(1, temp.size())) || isSymmetrical(temp.subList(0, temp.size()-1))) {
                    System.out.println(1);
                } else {
                    System.out.println(2);
                }
                return;
            }
        }
    }

    public static boolean isSymmetrical(List<String> list) {
        List<String> back = list.size()%2==0 ? new ArrayList<>(list.subList(list.size()/2, list.size())) : new ArrayList<>(list.subList(list.size()/2+1, list.size()));
        Collections.reverse(back);
        if (list.subList(0, list.size()/2).equals(back)) {
            return true;
        } else {
            return false;
        }
    }
}