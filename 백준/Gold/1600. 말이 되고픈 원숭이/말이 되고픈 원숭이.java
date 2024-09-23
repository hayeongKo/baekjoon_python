// 1600
// 말이 되고픈 원숭이

import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;
    int k;
    int cnt;
    public Node(int x, int y, int k, int cnt) {
        this.x = x;
        this.y = y;
        this.k = k;
        this.cnt = cnt;
    } 
}

public class Main {
    static int K, W, H;
    static int[][] board;
    static boolean[][][] visited;
    static ArrayDeque<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        String[] buffer = br.readLine().split(" ");
        W = Integer.parseInt(buffer[0]);
        H = Integer.parseInt(buffer[1]);

        board = new int[H][W];
        visited = new boolean[H][W][K+1];

        // board 초기화
        for (int i = 0; i < H; i++) {
            buffer = br.readLine().split(" ");
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(buffer[j]);
            }
        }

        if(!bfs(0, 0)) {
            System.out.println(-1);
        }
    }

    public static boolean bfs(int x, int y) {
        queue.offer(new Node(x, y, K, 0));
        visited[x][y][K] = true;

        int[] horseDx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] horseDy = {1, -1, 2, -2, 2, -2, 1, -1};

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == H-1 && current.y == W-1) {
                System.out.println(current.cnt);
                return true;
            }

            // 일반 움직임 확인
            for (int i = 0; i < 4; i++) {
                int nx = current.x+dx[i];
                int ny = current.y+dy[i];

                if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                    if (board[nx][ny] != 1 && !visited[nx][ny][current.k]) {
                        visited[nx][ny][current.k] = true;
                        queue.offer(new Node(nx, ny, current.k, current.cnt + 1));
                    }
                }
            }

            // 말의 움직임
            if (current.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = current.x+horseDx[i];
                    int ny = current.y+horseDy[i];

                    if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                        if (board[nx][ny] != 1 && !visited[nx][ny][current.k-1]) {
                            visited[nx][ny][current.k-1] = true;
                            queue.offer(new Node(nx, ny, current.k-1, current.cnt+1));
                        }
                    }
                }
            }
        }
        return false;
    }
}