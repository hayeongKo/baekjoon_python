import java.util.*;

class Solution {
    StringBuilder res;
    public String solution(String new_id) {
        
        //1단계: 대문자 -> 소문자
        new_id = new_id.toLowerCase();
        
        //2단계: 소문자, 숫자, -, _, . 제외한 모든 문자 제거
        new_id = step2(new_id);
        
        //3단계: .가 두번 연속된 부분을 하나의 마침표로 치환
        new_id = step3(new_id);
        
        //4단계: new_id가 .으로 시작하거나 끝나면 제거
        new_id = step4(new_id);
        
        //5단계: 빈 문자열이면 a 대입
        if(new_id.isEmpty()) {
            new_id = "a";
        }
        
        //6단계: 16자 이상이면 첫 15개의 문자를 제외한 나머지 문자 제거
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.endsWith(".")) {
                new_id = new_id.substring(0, 14);
            }
        }
        
        //7단계: 2자 이하면 마지막 문자를 길이가 3이 될 때까지 반복
        res = new StringBuilder(new_id);
        while(res.length() <= 2) {
            res.append(new_id.charAt(new_id.length()-1));
        }
        
        return res.toString();
    }
    
    public String step2(String id) {
        res = new StringBuilder();
        
        for(int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);
            if (Character.isLowerCase(c) || Character.isDigit(c) || c == '.' || c == '-' || c == '_' || c == '.') {
                res.append(c);
            } 
        }
        return res.toString();
    }
    
    public String step3(String id) {
        int temp = 0;
        res.setLength(0);
        
        for(int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);
            if (c == '.') {
                temp++;
            } else {
                if(temp > 0) {
                    res.append('.');
                    temp = 0;
                }
                res.append(c);
            }
        }
        
        return res.toString();
    }
    
    public String step4(String id) {
        if(id.startsWith(".")) {
            id = id.substring(1);
        }
        
        if(id.endsWith(".")) {
            id = id.substring(0, id.length()-2);
        }
        
        return id;
    }

}