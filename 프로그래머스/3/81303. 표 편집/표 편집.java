import java.util.*;

class Solution {
    TreeSet<Integer> table;
    ArrayDeque<Integer> deleted;
    int pointer;
    
    public String solution(int n, int k, String[] cmd) {
        table = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            table.add(i);
        }
        pointer = k;
        deleted = new ArrayDeque<>();
        
        for(String command : cmd) {
            if(command.startsWith("U")) {
                upPointer(command);
            } else if(command.startsWith("D")) {
                downPointer(command);
            } else if(command.startsWith("C")) {
                deleteSelected(n);
            } else if(command.startsWith("Z")) {
                undoDeleted();
            }
        }
        return compare(n);
    }
    
    public void upPointer(String command) {
        int cnt = Integer.parseInt(command.split(" ")[1]);
        while(cnt-- > 0) {
            pointer = table.lower(pointer);
        }
    }
    
    public void downPointer(String command) {
        int cnt = Integer.parseInt(command.split(" ")[1]);
        while(cnt-- > 0) {
            pointer = table.higher(pointer);
        }
    }
    
    public void deleteSelected(int n) {
        table.remove(pointer);
        deleted.offer(pointer);
        
        if(table.higher(pointer) != null) {
            pointer = table.higher(pointer);
        } else {
            pointer = table.lower(pointer);
        }
    }
    
    public void undoDeleted() {
        int cur = deleted.pollLast();
        table.add(cur);
    }
    
    public String compare(int n) {
        StringBuilder sb = new StringBuilder("O".repeat(n));
        for (int row : deleted) {
            sb.setCharAt(row, 'X'); // 삭제된 행에 'X' 표시
        }
        return sb.toString();
    }
}