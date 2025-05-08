import java.util.*;

class Solution {
    int N;
    HashSet<Integer> numberSet;
    
    public int solution(String numbers) {
        N = numbers.length();
        numberSet = new HashSet<>();
        
        permute("", numbers);
        
        int ans = 0;
        for(int num : numberSet) {
            if (isPrime(num)) ans++;
        }
        return ans;
    }
    
    public void permute(String prefix, String remain) {
        if (!prefix.isEmpty()) {
            numberSet.add(Integer.parseInt(prefix));
        }
        
        for(int i = 0; i < remain.length(); i++) {
            String nextPrefix = prefix + remain.charAt(i);
            String nextRemain = remain.substring(0, i) + remain.substring(i+1);
            permute(nextPrefix, nextRemain);
        }
    }
    
    
    
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n%2==0) return false;
        
        for(int i = 3; i <= Math.sqrt(n); i++) {
            if (n%i == 0) return false;
        }
        return true;
    }
}