import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows+1][columns+1];
        int n = 1;
        int[] answer = new int[queries.length];
        
        for(int i = 1; i < rows+1; i++) {
            for(int j = 1; j < columns+1; j++) {
                board[i][j] = n;
                n++;
            }
        }
        
        n = 0;
        
        for(int[] query : queries) {
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];
            
            int minNum = rows * columns;
            
            int temp1 = board[x1][y2];
            int temp2 = board[x2][y1];
            
            int prev = board[x1][y1];
            for(int j = y1; j <= y2; j++) {
                if(j == y1) {
                    board[x1][j] = board[x1+1][j];
                } else {
                    int temp = board[x1][j];
                    board[x1][j] = prev;
                    prev = temp;
                }
                
                minNum = Math.min(minNum, board[x1][j]);
            }
            
            prev = board[x2][y2];
            for(int j = y2; j >= y1; j--) {
                if(j == y2) {
                    board[x2][j] = board[x2-1][j];
                } else {
                    int temp = board[x2][j];
                    board[x2][j] = prev;
                    prev = temp;
                }
                
                minNum = Math.min(minNum, board[x2][j]);
            }
            
            prev = temp2;
            for(int i = x2-1; i >= x1; i--) {
                int temp = board[i][y1];
                board[i][y1] = prev;
                prev = temp;
                
                minNum = Math.min(minNum, board[i][y1]);
            }
            
            prev = temp1;
            for(int i = x1+1; i <= x2; i++) {
                int temp = board[i][y2];
                board[i][y2] = prev;
                prev = temp;
                
                minNum = Math.min(minNum, board[i][y2]);
            }
            answer[n++] = minNum;
            // for(int[] line : board) {
            //     for(int k : line) {
            //         System.out.printf("%3d", k);
            //     }
            //     System.out.println();
            // }
            // System.out.println("------");
        }
        return answer;
    }
}