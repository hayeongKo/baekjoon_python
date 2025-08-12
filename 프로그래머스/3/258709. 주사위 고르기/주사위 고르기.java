import java.util.*;

class Solution {
    class Result {
        int win, same, lose;
        Result(int win, int same, int lose) {
            this.win = win;
            this.same = same;
            this.lose = lose;
        }
    }
    
    int N;
    Map<Integer, Result> results;
    boolean[] visited;
    int mWin, mKey;
    List<Integer> scoreA, scoreB;
    int[][] dices;
    
    public int[] solution(int[][] dice) {
        N = dice.length;
        results = new HashMap<>();
        visited = new boolean[N];
        dices = dice;
        divideDice(0, 0);
        
        int[] answer = new int[N/2];
        int id = 0;
        for(int i = 0; i < N; i++) {
            if ((mKey & 1 << i) == (int)Math.pow(2, i)) answer[id++] = i+1;
        }
        return answer;
    }
    
    public void divideDice(int depth, int start) {
        if (depth == N/2) {
            if (!results.containsKey(getKey(true))) play();
            return;
        }
        
        for(int i = start; i < N; i++) {
            visited[i] = true;
            divideDice(depth+1, i+1);
            visited[i] = false;
        }
        
    }
    
    // 점수 대결
    public void play() {
        scoreA = new ArrayList<>();
        getScore(0, true, 0);
        
        scoreB = new ArrayList<>();
        getScore(0, false, 0);
        
        int win = 0;
        int lose = 0;
        int same = 0;
        
        scoreA.sort(Comparator.naturalOrder());
        scoreB.sort(Comparator.naturalOrder());
        
        // for(int a : scoreA) {
        //     System.out.print(a + " ");
        // }
        // System.out.println();
        // for(int a : scoreB) {
        //     System.out.print(a + " ");
        // }
        // System.out.println();
        // 승부 비교
        for(int a : scoreA) {
            int left = 0; int right = scoreB.size()-1;
            
            while (left <= right && scoreB.get(left) < a) {
                win++;
                left++;
            }
            
            while (left <= right && scoreB.get(left) == a) {
                same++;
                left++;
            }
            
            lose += (scoreB.size()-left);
        }
        
        // System.out.println("win: " + win + " same:" + same + " lose: " + lose);
        
        int ak = getKey(true);
        int bk = getKey(false);
        
        if (mWin < win) {
            mWin = win;
            mKey = ak;
        }
        
        if (mWin < lose) {
            mWin = lose;
            mKey = bk;
        }
        
        results.put(ak, new Result(win, same, lose));
        results.put(bk, new Result(lose, same, win));
    }
    
    // 가진 주사위로 나올 수 있는 점수의 경우의 수
    public void getScore(int depth, boolean isA, int sum) {
        if (depth == N) {
            if (isA) scoreA.add(sum);
            else if (!isA) scoreB.add(sum);
            return;
        }
        
        if (visited[depth] == isA) {
            for(int i = 0; i < 6; i++) {
                getScore(depth+1, isA, sum+dices[depth][i]);
            }
        } else {
            getScore(depth+1, isA, sum);
        }

    }
    
    // 비트마스킹으로 방문 확인
    public int getKey(boolean flag) {
        int key = 0;
        for(int i = 0; i < N; i++) {
            if (visited[i] == flag) key |= 1 << i;
        }
        return key;
    }
}