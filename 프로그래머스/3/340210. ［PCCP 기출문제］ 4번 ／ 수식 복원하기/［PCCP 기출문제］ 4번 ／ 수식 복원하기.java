import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        int minBase = 2;
        List<String> unknowns = new ArrayList<>();
        List<String> knowns = new ArrayList<>();
        
        // 최소 진법 찾기 & 식 분류
        for(String expr : expressions) {
            for (char c : expr.toCharArray()) {
                if (Character.isDigit(c)) {
                    minBase = Math.max(minBase, (c - '0') + 1);
                }
            }
            
            if (expr.contains("= X")) {
                unknowns.add(expr);
            } else {
                knowns.add(expr);
            }
        }
        
        // 가능한 진법 찾기
        Set<Integer> possibleBases = new HashSet<>();
        for (int base = minBase; base <= 9; base++) {
            boolean valid = true;
            for (String expr : knowns) {
                if (!isValidExpression(expr, base)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                possibleBases.add(base);
            }
        }
        
        // 결과 계산
        String[] ans = new String[unknowns.size()];
        for (int i = 0; i < unknowns.size(); i++) {
            String expr = unknowns.get(i);
            String[] parts = expr.split(" ");
            String a = parts[0];
            String oper = parts[1];
            String b = parts[2];
            
            Set<String> results = new HashSet<>();
            for (int base : possibleBases) {
                try {
                    int A = Integer.parseInt(a, base);
                    int B = Integer.parseInt(b, base);
                    int R = oper.equals("+") ? (A + B) : (A - B);
                    results.add(Integer.toString(R, base));
                } catch (NumberFormatException e) {
                    // 유효하지 않은 진법
                }
            }
            
            if (results.size() == 1) {
                ans[i] = a + " " + oper + " " + b + " = " + results.iterator().next();
            } else {
                ans[i] = a + " " + oper + " " + b + " = ?";
            }
        }
        
        return ans;
    }
    
    private boolean isValidExpression(String expr, int base) {
        String[] parts = expr.split(" ");
        String a = parts[0];
        String oper = parts[1];
        String b = parts[2];
        String res = parts[4];
        
        try {
            int A = Integer.parseInt(a, base);
            int B = Integer.parseInt(b, base);
            int R = Integer.parseInt(res, base);
            
            if (oper.equals("+")) {
                return (A + B) == R;
            } else {
                return (A - B) == R;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }
}