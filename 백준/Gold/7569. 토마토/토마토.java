import java.util.*;
import java.io.*;

public class Main {
    static int M, N, H;
    static int[][][] tomatos; // 1: 익음 0: 익지 않음 -1: 빈칸
    static int prev;
    static ArrayDeque<Point> queue;
    static int maxDay;
    static int ripeCnt;

    static class Point{
        int x, y, h, day;
        Point(int h, int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.day = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        M = Integer.parseInt(inputs[0]);
        N = Integer.parseInt(inputs[1]);
        H = Integer.parseInt(inputs[2]);
        maxDay = Integer.MIN_VALUE;
        queue = new ArrayDeque<>();

        // 토마토 초기화
        tomatos = new int[H][N][M];
        ripeCnt = 0;
        int totalTomatos = 0;

        for(int h = 0; h < H; h++) {
            for(int i = 0; i < N; i++) {
                inputs = br.readLine().split(" ");
                for(int j = 0; j < M; j++) {
                    tomatos[h][i][j] = Integer.parseInt(inputs[j]);
                    if (tomatos[h][i][j] == 1) {
                        queue.offer(new Point(h, i, j, 0));
                        ripeCnt++;
                    }
                    
                    if(tomatos[h][i][j] != -1) {
                        totalTomatos++;
                    }
                }
            }
        }

        ripe();
        if (ripeCnt==totalTomatos) {
            System.out.println(maxDay);
        } else {
            System.out.println(-1);
        }
    }

    public static void ripe() {

        int[] dx = {0, 0, 0, 0, 1, -1};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dh = {1, -1, 0, 0, 0, 0};

        while(!queue.isEmpty()) {
            Point now = queue.pop();
            maxDay = Math.max(maxDay, now.day);
            for(int i = 0; i < 6; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nh = now.h + dh[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && nh >= 0 && nh < H && tomatos[nh][nx][ny] == 0) {
                    tomatos[nh][nx][ny] = 1;
                    ripeCnt++;
                    queue.offer(new Point(nh, nx, ny, now.day+1));
                }
            }
        }
    }
}