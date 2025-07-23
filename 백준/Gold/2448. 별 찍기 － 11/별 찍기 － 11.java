import java.io.*;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][2*N-1];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 2*N-1; j++) {
                map[i][j] = ' ';
            }
        }
        draw(0, (2*N-1)/2, N);
        print(N);
    }

    public static void draw(int x, int y, int size) {
        if (size == 3) {
            map[x][y] = '*';
            map[x+1][y-1] = '*'; map[x+1][y+1] = '*';
            for(int j = y-2; j <= y+2; j++) {
                map[x+2][j] = '*';
            }
        } else {
            draw(x, y, size/2);
            draw(x+size/2, y-size/2, size/2);
            draw(x+size/2, y+size/2, size/2);
        }
    }

    public static void print(int N) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 2*N-1; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
