import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        
        long[] bansNums = new long[bans.length];
        for(int i = 0; i < bans.length; i++) {
            bansNums[i] = strToNum(bans[i]); // 26진수 -> 10진수 변환
        }
        
        Arrays.sort(bansNums);
        
        for(long bn : bansNums) if(bn <= n) n++;
        answer = numToStr(n);
        
        return answer;
    }
    
    private long strToNum(String str) {
        int length = str.length();
        long res = 0;
        for(int i = 0; i < length; i++) {
            res += (str.charAt(i)-96)*Math.pow(26, (length-1-i));
        }
        return res;
    }
    
    private String numToStr(long num) {
        String str = "";
        while(num > 0) {
            str = String.valueOf((char)((num-1)%26+1+96)) + str;
            num = (num-1)/26;
        }
        return str;
    }
    
    
}