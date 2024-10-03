
// 1913
// 달팽이

import java.io.*;

public class Main {
    static int[][] board;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int x = 0, y = 0;

        board = new int[N][N];

        int k = 0;
        for(int j = N; j >= 1; j-=2) {
            snail(j, k);
            k++;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == target) {
                    x = i+1;
                    y = j+1;
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(x + " " + y);
    }

    public static void snail(int n, int k) {
        
        int last = n*n;

        // 왼쪽 아래로
        for(int i = 0; i < n; i++) {
            board[i+k][k] = last--;
        }

        // 아래 오른쪽으로
        for(int i = 1; i < n; i++) {
            board[n-1+k][i+k] = last--;
        }

        // 오른쪽 위로
        for(int i = n-2; i >= 0; i--) {
            board[i+k][n-1+k] = last--;
        }

        // 위 왼쪽으로
        for(int i = n-2; i > 0; i--) {
            board[k][i+k] = last--;
        }
    }
}
