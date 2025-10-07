import java.util.*;

class Solution {
    int[] dx = {0, 1, -1, 0};
    int[] dy = {1, 0, 0, -1}; // 동 남 북 서
    int N, M;

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        N = board.length;
        M = board[0].length;
        return play(true, board, aloc, bloc).turnCount;
    }

    class Result {
        boolean win; // 현재 턴 플레이어의 승패
        int turnCount; // 총 턴 수
        Result(boolean w, int t) {
            win = w;
            turnCount = t;
        }
    }

    // turn==true -> a else b
    public Result play(boolean turn, int[][] board, int[] apos, int[] bpos) {
        int[] cur = turn ? apos : bpos; // 현재 플레이어
        int[] opp = turn ? bpos : apos; // 상대 플레이어

        // 현재 발판이 이미 사라진 경우
        if (board[cur[0]][cur[1]] == 0) {
            return new Result(false, 0);
        }

        boolean canMove = false;
        boolean canWin = false;
        int minWin = Integer.MAX_VALUE;
        int maxLose = 0;

        List<Integer> movable = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int nx = cur[0] + dx[i];
            int ny = cur[1] + dy[i];
            if (inRange(nx, ny) && board[nx][ny] == 1) {
                movable.add(i);
            }
        }

        if (movable.isEmpty()) {
            return new Result(false, 0);
        }

        for (int d : movable) {
            int nx = cur[0] + dx[d];
            int ny = cur[1] + dy[d];

            board[cur[0]][cur[1]] = 0;

            int[] nextA = Arrays.copyOf(apos, 2);
            int[] nextB = Arrays.copyOf(bpos, 2);
            if (turn) nextA = new int[]{nx, ny};
            else nextB = new int[]{nx, ny};

            Result res = play(!turn, board, nextA, nextB);

            board[cur[0]][cur[1]] = 1;

            canMove = true;
            if (!res.win) { // 상대가 졌다 → 내가 이김
                canWin = true;
                minWin = Math.min(minWin, res.turnCount + 1);
            } else { // 상대가 이김 → 나는 졌음
                maxLose = Math.max(maxLose, res.turnCount + 1);
            }
        }

        // 결과 결정
        if (canWin) return new Result(true, minWin);
        else return new Result(false, maxLose);
    }

    public boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
