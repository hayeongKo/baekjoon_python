import java.io.*;

public class Main {
    static int R, C, T, tx, bx;
    static int[][] room;
    static int[][] dust;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        R = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);
        T = Integer.parseInt(inputs[2]);
        room = new int[R][C];
        dust = new int[R][C];

        boolean flag = false;
        for(int i = 0; i < R; i++) {
            inputs = br.readLine().split(" ");
            for(int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(inputs[j]);
                if (!flag && room[i][j] == -1) {
                    flag = true;
                    tx = i;
                    bx = i+1;
                }
            }
        }

        while(T-- > 0) {
            spread();
        }

        int answer = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (room[i][j] > 0) answer += room[i][j];
            }
        }

        System.out.println(answer);
    }

    public static void spread() {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        // 미세먼지 확산
        int nx, ny, cnt;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (room[i][j] != 0) {
                    cnt = 0;
                    for(int d = 0; d < 4; d++) {
                        nx = i + dx[d];
                        ny = j + dy[d];
                        if (0 <= nx && nx < R && 0 <= ny && ny < C && room[nx][ny] != -1) {
                            dust[nx][ny] += room[i][j]/5;
                            cnt++;
                        }
                    }
                    dust[i][j] -= cnt*(room[i][j]/5);
                }
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                room[i][j] += dust[i][j];
                dust[i][j] = 0; // 초기화
            }
        }

        //공기청정기 작동
        for(int i = tx-1; i > 0; i--) room[i][0] = room[i-1][0]; //아래로
        for(int i = 0; i < C-1; i++) room[0][i] = room[0][i+1]; // 좌로
        for(int i = 0; i < tx; i++) room[i][C-1] = room[i+1][C-1];//위로
        for(int i = C-1; i > 1; i--) room[tx][i] = room[tx][i-1]; // 오른쪽으로
        room[tx][1] = 0;

        for(int i = bx+1; i < R-1; i++) room[i][0] = room[i+1][0];
        for(int i = 0; i < C-1; i++) room[R-1][i] = room[R-1][i+1];
        for(int i = R-1; i > bx; i--) room[i][C-1] = room[i-1][C-1];
        for(int i = C-1; i > 1; i--) room[bx][i] = room[bx][i-1];
        room[bx][1] = 0;
    
    }
}
