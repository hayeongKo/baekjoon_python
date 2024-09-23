// 16918
// 봄버맨
import java.util.*;
import java.io.*;
class Bomb {
    int x;
    int y;
    int t;
    Bomb(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

public class Main {
    static String[][][] board;
    static String[][] initial;
    static int R, C, N;
    static boolean[][] visited;
    static ArrayDeque<Bomb> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        R = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);
        N = Integer.parseInt(inputs[2]);

        initial = new String[R][C];
        board = new String[R][C][4];

        for(int i = 0; i < R; i++) {
            String[] temp = br.readLine().split("");
            for(int j = 0; j < C; j++) {
                initial[i][j] = temp[j];
                board[i][j][1] = "O";
                board[i][j][2] = "O";
                board[i][j][3] = "O";
                board[i][j][0] = "O";
                if (temp[j].equals("O")) {
                    queue.offer(new Bomb(i, j, 1));
                }
            }
        }

        bomberman();
        // System.out.println("-----------");
        if (N == 1) {
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    System.out.print(initial[i][j]);
                }
                System.out.println();
            }
        } else {
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    System.out.print(board[i][j][N%4]);
                }
                System.out.println();
            }
        }
    }

    public static void bomberman() {
        
        bfs(3); //N%4 == 3
        // 3번째 폭탄 수거
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j][3].equals("O")) {
                    queue.offer(new Bomb(i, j, 3));
                }
            }
        }
        bfs(1); // N%4 == 1
    }

    public static void bfs(int t) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        visited = new boolean[R][C];

        while (!queue.isEmpty()) {
            Bomb temp = queue.poll();
            visited[temp.x][temp.y] = true;
            board[temp.x][temp.y][t] = ".";

            for(int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        board[nx][ny][t] = ".";
                    }
                }
            }
        }
    }
}