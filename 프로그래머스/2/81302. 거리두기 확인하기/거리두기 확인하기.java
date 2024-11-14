import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0; i < 5; i++) {
            answer[i] = check(places[i]);
        }
        return answer;
    }
    
    public int check(String[] place) {
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    int startI = i-2 < 0 ? 0 : i-2;
                    int startJ = j-2 < 0 ? 0 : j-2;
                    int endI = i+2 > 4 ? 4 : i+2;
                    int endJ = j+2 > 4 ? 4 : j+2;
                    
                    for(int x = startI; x <= endI; x++) {
                        for(int y = startJ; y <= endJ; y++) {
                            if((x != i || y != j) && place[x].charAt(y) == 'P') {
                                int dist = Math.abs(i-x) + Math.abs(j-y);
                                if (dist == 1) return 0;
                                if (dist == 2) {
                                    if (i == x) {
                                        if (j < y && place[i].charAt(j+1) != 'X' || j > y && place[i].charAt(j-1) != 'X') return 0;
                                    } else if (j == y) {
                                        if (i > x && place[i-1].charAt(j) != 'X' || i < x && place[i+1].charAt(j) != 'X') return 0;
                                    } else {
                                        if (x < i) {
                                            if (y < j) {
                                                if(place[i-1].charAt(j) != 'X' || place[i].charAt(j-1) != 'X') return 0;
                                            } else {
                                                if(place[i-1].charAt(j) != 'X' || place[i].charAt(j+1) != 'X') return 0;
                                            }
                                        } else {
                                            if (y < j) {
                                                if(place[i+1].charAt(j) != 'X' || place[i].charAt(j-1) != 'X') return 0;
                                            } else {
                                                if(place[i+1].charAt(j) != 'X' || place[i].charAt(j+1) != 'X') return 0;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
}