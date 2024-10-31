// 14500
// 테트로미노

import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int res;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        map = new int[N][M];
        visited = new boolean[N][M];
        res = 0;

        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(0, i, j, map[i][j]);
                    visited[i][j] = false;
                }
                rest(i, j, map[i][j]); // 'ㅗ'모양 확인
            }
        }

        System.out.println(res);
    }

    public static void dfs(int depth, int x, int y, int sum) {
        if (depth == 3) {
            res = Math.max(res, sum);
            return;
        }

        for (int i = 0; i < 4 ;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(depth+1, nx, ny, sum + map[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    public static void rest(int x, int y, int total) {
        int blocks = 0;
        int minBlock = Integer.MAX_VALUE;

        for (int i = 0; i < 4 ;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            blocks++;
            minBlock = Math.min(minBlock, map[nx][ny]);
            total += map[nx][ny];
        }

        if (blocks == 3) {
            res = Math.max(res, total);
        } else if (blocks == 4) {
            res = Math.max(res, total-minBlock);
        }
    }
}