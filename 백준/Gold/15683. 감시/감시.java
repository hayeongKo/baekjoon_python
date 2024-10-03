// 15683
// 감시

import java.io.*;
import java.util.ArrayList;

public class Main {
    static int N, M;
    static int[][] spaces;
    static int minNum = Integer.MAX_VALUE;

    public static class cctv {
        int x,y;
        int type;
        cctv(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        spaces = new int[N][M];
        ArrayList<cctv> cctvs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                spaces[i][j] = Integer.parseInt(inputs[j]);
                if(spaces[i][j] != 0 && spaces[i][j] != 6) {
                    cctvs.add(new cctv(i, j, spaces[i][j]));
                }
            }
        }

        dfs(0, spaces, cctvs);
        System.out.println(minNum);
    }

    public static void dfs(int depth, int[][] spaces, ArrayList<cctv> cctvs) {
        // cctv 다 돌면 종료
        if(depth == cctvs.size()) {
            minNum = Math.min(minNum, countZero(spaces));
            return;
        }

        cctv cctv = cctvs.get(depth);
        int x = cctv.x;
        int y = cctv.y;
        int type = cctv.type;
        int[][] temp;

        if(type == 1) {
            temp = copyArray(spaces);
            checkLeft(temp, x, y);
            dfs(depth+1, temp, cctvs);

            temp = copyArray(spaces);
            checkRight(temp, x, y);
            dfs(depth+1, temp, cctvs);

            temp = copyArray(spaces);
            checkUp(temp, x, y);
            dfs(depth+1, temp, cctvs);

            temp = copyArray(spaces);
            checkDown(temp, x, y);
            dfs(depth+1, temp, cctvs);
        } else if (type == 2) {
            temp = copyArray(spaces);
            checkLeft(temp, x, y);
            checkRight(temp, x, y);
            dfs(depth+1, temp, cctvs);

            temp = copyArray(spaces);
            checkDown(temp, x, y);
            checkUp(temp, x, y);
            dfs(depth+1, temp, cctvs);
        } else if (type == 3) {
            temp = copyArray(spaces);
            checkLeft(temp, x, y);
            checkUp(temp, x, y);
            dfs(depth+1, temp, cctvs);

            temp = copyArray(spaces);
            checkLeft(temp, x, y);
            checkDown(temp, x, y);
            dfs(depth+1, temp, cctvs);

            temp = copyArray(spaces);
            checkRight(temp, x, y);
            checkUp(temp, x, y);
            dfs(depth+1, temp, cctvs);

            temp = copyArray(spaces);
            checkRight(temp, x, y);
            checkDown(temp, x, y);
            dfs(depth+1, temp, cctvs);
        } else if (type == 4) {
            temp = copyArray(spaces);
            checkLeft(temp, x, y);
            checkUp(temp, x, y);
            checkRight(temp, x, y);
            dfs(depth+1, temp, cctvs);

            temp = copyArray(spaces);
            checkUp(temp, x, y);
            checkRight(temp, x, y);
            checkDown(temp, x, y);
            dfs(depth+1, temp, cctvs);

            temp = copyArray(spaces);
            checkLeft(temp, x, y);
            checkDown(temp, x, y);
            checkRight(temp, x, y);
            dfs(depth+1, temp, cctvs);

            temp = copyArray(spaces);
            checkLeft(temp, x, y);
            checkUp(temp, x, y);
            checkDown(temp, x, y);
            dfs(depth+1, temp, cctvs);
        } else if (type == 5) {
            temp = copyArray(spaces);
            checkLeft(temp, x, y);
            checkUp(temp, x, y);
            checkRight(temp, x, y);
            checkDown(temp, x, y);
            dfs(depth+1, temp, cctvs);
        }
        
    }

    public static int[][] copyArray(int[][] spaces) {
        int[][] copyArray = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyArray[i][j] = spaces[i][j];
            }
        }
        return copyArray;
    }

    public static void checkLeft(int[][] spaces, int x, int y) {
        for(int i = y-1; i >= 0; i--) {
            if(spaces[x][i] == 6) {
                return;
            }
            if(spaces[x][i] != 0) {
                continue;
            }
            spaces[x][i] = -1;
        }
    }
    public static void checkRight(int[][] spaces, int x, int y) {
        for(int i = y+1; i < M; i++) {
            if(spaces[x][i] == 6) {
                return;
            }
            if(spaces[x][i] != 0) {
                continue;
            }
            spaces[x][i] = -1;
        }
    }
    public static void checkUp(int[][] spaces, int x, int y) {
        for(int i = x-1; i >= 0; i--) {
            if(spaces[i][y] == 6) {
                return;
            }
            if(spaces[i][y] != 0) {
                continue;
            }
            spaces[i][y] = -1;
        }
    }
    public static void checkDown(int[][] spaces, int x, int y) {
        for(int i = x+1; i < N; i++) {
            if(spaces[i][y] == 6) {
                return;
            }
            if(spaces[i][y] != 0) {
                continue;
            }
            spaces[i][y] = -1;
        }
    }

    public static int countZero(int[][] spaces) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(spaces[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
