// 2615
// 오목

import java.io.*;

public class Main {
    static int[][] board = new int[19][19];
    static boolean[][] visited = new boolean[19][19];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs;
        for(int i = 0; i < 19; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if(board[i][j] != 0) {
                    int cnt = 1;
                    // 오른쪽
                    for(int k = 1; k < 5; k++) {
                        if(j+k < 19 && board[i][j+k] == board[i][j]) {
                            cnt++;
                            if(cnt == 5) {
                                if((j-1 >= 0 && board[i][j-1] == board[i][j]) || (j+k+1 < 19 && board[i][j+k+1] == board[i][j])) {
                                    cnt = 1;
                                    break;
                                }
                                System.out.println(board[i][j]);
                                System.out.println((i+1) + " " + (j+1));
                                return;
                            }
                        } else {
                            cnt = 1;
                            break;
                        }
                    }
                    // 아래
                    for(int k = 1; k < 5; k++) {
                        if(i+k < 19 && board[i+k][j] == board[i][j]) {
                            cnt++;
                            // 육목
                            if(cnt == 5) {
                                if((i-1 >= 0 && board[i-1][j] == board[i][j]) || (i+k+1 < 19 && board[i+k+1][j] == board[i][j])) {
                                    cnt = 1;
                                    break;
                                }
                                System.out.println(board[i][j]);
                                System.out.println((i+1) + " " + (j+1));
                                return;
                            }
                        } else {
                            cnt = 1;
                            break;
                        }
                    }
                    // 오른쪽 아래 대각
                    for(int k = 1; k < 5; k++) {
                        if(i+k < 19 && j+k < 19 && board[i+k][j+k] == board[i][j]) {
                            cnt++;
                            if(cnt == 5) {
                                // 육목
                                if((i+k+1 < 19 && j+k+1 < 19 && board[i+k+1][j+k+1] == board[i][j]) || (i-1>=0 && j-1>=0 && board[i-1][j-1] == board[i][j])) {
                                    cnt = 1;
                                    break;
                                }
                                System.out.println(board[i][j]);
                                System.out.println((i+1) + " " + (j+1));
                                return;
                            }
                        } else {
                            cnt = 1;
                            break;
                        }
                    }
                    // 오른쪽 위 대각
                    for(int k = 1; k < 5; k++) {
                        if (0 <= i-k && i-k < 19 && j+k < 19 && board[i-k][j+k] == board[i][j]) {
                            cnt++;
                            if(cnt == 5) {
                                // 육목
                                if((0 <= i-k-1 && i-k-1 < 19 && j+k+1 < 19 && board[i-k-1][j+k+1] == board[i][j]) || (i+1 < 19 && j-1 >= 0 && board[i+1][j-1] == board[i][j])) {
                                    cnt = 1;
                                    break;
                                }
                                System.out.println(board[i][j]);
                                System.out.println((i+1) + " " + (j+1));
                                return;
                            }
                        } else {
                            cnt = 1;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("0");
    }
}