import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        //k진법으로 변경
        StringBuilder sb = new StringBuilder();
        
        while(n > k) {
            sb.append(n%k);
            n /= k;
        }
        sb.append(n);
        
        sb.reverse();
        
        String output = sb.toString();
        System.out.println(output);
        
        int ans = 0;
        for(String num : output.split("0")) {
            if (num.isEmpty()) continue;
            if(isPrime(Long.parseLong(num))) ans++;
        }
        
        return ans;
    }
    
    public boolean isPrime(long num) {
        if(num == 1) return false;
        if(num == 2) return true;
        for(int i = 2; i <= Math.sqrt(num) + 1; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}