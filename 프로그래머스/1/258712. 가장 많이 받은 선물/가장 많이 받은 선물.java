import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[][] table = new int[friends.length][friends.length];
        int[] score = new int[friends.length];
        
        for(String gift : gifts) {
            String[] buffer = gift.split(" ");
            String sender = buffer[0];
            String receiver = buffer[1];
            
            int senderId = 0;
            while(true) {
                if(friends[senderId].equals(sender)) break;
                senderId++;
            }
            
            int receiverId = 0;
            while(true) {
                if(friends[receiverId].equals(receiver)) break;
                receiverId++;
            }
            
            table[senderId][receiverId]++;
            score[senderId]++;
            score[receiverId]--;
        }
        
        int[] result = new int[friends.length];
        for(int i = 0; i < friends.length; i++) {
            for(int j = 0; j < friends.length ; j++) {
                if (i == j) continue;
                if(table[i][j] > table[j][i]) {
                    result[i]++;
                } else if (table[i][j]==table[j][i]) {
                    if (score[i] > score[j]) result[i]++;
                }
            }
        }
        
        int min = 0;
        int max = Integer.MIN_VALUE;
        for(int res : result) {
            if (res == 0) continue;
            
            if (res > max) {
                max = res;
            }
        }
        if (max == Integer.MIN_VALUE) return 0;
        return max;
    }
}