import java.util.*;
import java.io.*;

// 뱀
public class Main {
    static int N, K, T;
    static int[][] board;
    static ArrayDeque<Point> snake;
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        snake = new ArrayDeque<>();

        board = new int[N][N];
        String[] inputs;
        for(int i = 0; i < K; i++) {
            inputs = br.readLine().split(" ");
            board[Integer.parseInt(inputs[0])-1][Integer.parseInt(inputs[1])-1] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        int time = 0;

        int d = 0;
        int[] dx = {0, 1, 0, -1}; // 동 남 서 북
        int[] dy = {1, 0, -1, 0};
        
        int x = 0;
        int y = 0;
        snake.add(new Point(0, 0));

        for(int l = 0; l < L; l++) {
            inputs = br.readLine().split(" ");
            T = Integer.parseInt(inputs[0]);
            while(true) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                time++;

                // 벽
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    System.out.println(time);
                    return;
                }

                if (board[nx][ny] == 1) {
                    board[nx][ny] = 2; // 뱀
                    snake.offer(new Point(nx, ny));
                } else if (board[nx][ny] == 2) {
                    System.out.println(time);
                    return;
                } else if (board[nx][ny] == 0) {
                    Point empty = snake.pop();
                    board[empty.x][empty.y] = 0;
                    board[nx][ny] = 2;
                    snake.add(new Point(nx, ny));
                }

                x = nx;
                y = ny;
                if (time == T) break;
            }

            if (inputs[1].equals("L")) d = (d+3)%4;
            else if (inputs[1].equals("D")) d = (d+1)%4;

        }

        while(true) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            time++;

            // 벽
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                break;
            }

            if (board[nx][ny] == 1) {
                board[nx][ny] = 2; // 뱀
                snake.offer(new Point(nx, ny));
            } else if (board[nx][ny] == 2) {
                break;
            } else if (board[nx][ny] == 0) {
                Point empty = snake.pop();
                board[empty.x][empty.y] = 0;
                board[nx][ny] = 2;
                snake.add(new Point(nx, ny));
            }

            x = nx;
            y = ny;
        }

        System.out.println(time);
    }
}
