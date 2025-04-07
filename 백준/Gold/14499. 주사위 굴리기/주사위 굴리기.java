import java.util.*;
import java.io.*;

public class Main {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice;
    static int[] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]); // 지도
        M = Integer.parseInt(inputs[1]);
        x = Integer.parseInt(inputs[2]); // 주사위 좌표
        y = Integer.parseInt(inputs[3]);
        K = Integer.parseInt(inputs[4]); // 명령 개수
        dice = new int[7];
        map = new int[N][M];      
        tmp = new int[7];

        for(int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        inputs = br.readLine().split(" ");
        int command, nx, ny;
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        for(int i = 0; i < K; i++) {
            command = Integer.parseInt(inputs[i]);
            nx = x + dx[command%4];
            ny = y + dy[command%4];

            if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                roll(command%4); // 주사위 굴리기
                if (map[nx][ny] == 0) {
                    map[nx][ny] = dice[6];
                } else {
                    dice[6] = map[nx][ny];
                    map[nx][ny] = 0;
                }
                System.out.println(dice[1]);
                x = nx;
                y = ny;
            } else {
                continue;
            }
        }
    }

    public static void roll(int dir) {
        int[] tmp = dice.clone();

        if (dir == 0) { // 남
            dice[1] = tmp[2];
            dice[2] = tmp[6];
            dice[5] = tmp[1];
            dice[6] = tmp[5];
        } else if (dir == 1) {// 동 
            dice[1] = tmp[4];
            dice[3] = tmp[1];
            dice[4] = tmp[6];
            dice[6] = tmp[3];
        } else if (dir == 2) {// 서
            dice[1] = tmp[3];
            dice[3] = tmp[6];
            dice[4] = tmp[1];
            dice[6] = tmp[4];
        } else if (dir == 3) {// 북
            dice[1] = tmp[5];
            dice[2] = tmp[1];
            dice[5] = tmp[6];
            dice[6] = tmp[2];
        } 
    }
}
