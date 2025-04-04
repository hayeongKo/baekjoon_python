import java.io.*;
import java.util.*;

public class Main {
    static int N, M, cnt, destx, desty;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Pos {
        int rx, ry, bx, by, cnt;
        Pos(int cnt) {this.cnt = cnt;};
        Pos(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        board = new int[N][M];
        Pos init = new Pos(0);


        for(int i = 0; i < N; i++) {
            inputs = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                if (inputs[j].equals("#")) {
                    board[i][j] = -1; // 벽
                } else if (inputs[j].equals(".")) {
                    board[i][j] = 0; // 빈 곳
                } else if (inputs[j].equals("O")) {
                    board[i][j] = 1; // 구멍
                    destx = i;
                    desty = j;
                } else if (inputs[j].equals("R")) {
                    board[i][j] = 2; // 빨간공
                    init.rx = i;
                    init.ry = j;
                } else if (inputs[j].equals("B")) {
                    board[i][j] = -2; // 파란곳
                    init.bx = i;
                    init.by = j;
                }
            }
        }

        // System.out.println("------------------------------------");
        // for(int i = 0; i < N; i++) {
        //     for(int j = 0; j < M; j++) {
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(bfs(init));
    }

    public static int bfs(Pos init) {
        ArrayDeque<Pos> queue = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[N][M][N][M];
        queue.offer(init);
        visited[init.rx][init.ry][init.bx][init.by] = true;

        int rx, ry, bx, by;

        while(!queue.isEmpty()) {
            Pos now = queue.pop();

            if(now.cnt > 10) {
                return -1;
            }

            for(int i = 0; i < 4; i++) {
                int[] redMove = move(now.rx, now.ry, dx[i], dy[i]);
                int[] blueMove = move(now.bx, now.by, dx[i], dy[i]);

                int redSteps = redMove[2];
                int blueSteps = blueMove[2];

                rx = redMove[0];
                ry = redMove[1];
                bx = blueMove[0];
                by = blueMove[1];

                if (board[bx][by] == 1) continue;
                if (board[rx][ry] == 1) {
                    if (now.cnt+1 > 10) {
                        return -1;
                    } 
                    return now.cnt+1;
                };

                if (rx == bx && ry == by) {
                    if (redSteps > blueSteps) {
                        rx -= dx[i];
                        ry -= dy[i];
                    } else {
                        bx -= dx[i];
                        by -= dy[i];
                    }
                }

                if (!visited[rx][ry][bx][by]) {
                    visited[rx][ry][bx][by] = true;
                    queue.offer(new Pos(rx, ry, bx, by, now.cnt+1));
                }

            }
        }
        return -1;
    }

    public static int[] move(int x, int y, int dx, int dy) {
        int cnt = 0;
        
        // 벽에 부딪힐 때까지
        while(true) {
            if (board[x+dx][y+dy] == -1) break;
            x += dx;
            y += dy;
            cnt++;
            if (board[x][y] == 1) break;
        }
        
        return new int[]{x, y, cnt}; // 움직인 후 (x, y, 움직인 횟수)
    }


}