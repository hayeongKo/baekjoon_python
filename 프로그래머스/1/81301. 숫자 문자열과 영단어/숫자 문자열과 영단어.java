import java.util.*;

class Solution {
    int cur = 0;
    List<String> nums;
    
    public int solution(String s) {
        String[] numsString = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        nums = new ArrayList<>();
        for(String num : numsString) {
            nums.add(num);
        }
        
        StringBuilder answer = new StringBuilder();
        
        while(true) {
            if ('0' <= s.charAt(cur) && s.charAt(cur) <= '9') {
                answer.append(s.charAt(cur++));
            } else {
                answer.append(notDigit(s));
            }
            
            if (cur == s.length()) break;
        }
        
        return Integer.parseInt(answer.toString());
    }
    
    public String notDigit(String s) {
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            String temp = sb.toString();
            for(int i = 0; i < 10; i++) {
                if(temp.equals(nums.get(i))) {
                    return Integer.toString(i);
                }
            }
            
            sb.append(s.charAt(cur++));
        }
    }
}