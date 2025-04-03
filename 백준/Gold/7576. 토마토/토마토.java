import java.util.*;
import java.io.*;

public class Main {
    static int M, N;
    static int[][] tomato;
    static List<Point> tomatoForCheck;
    static int answer, totalTomato;

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        tomato = new int[M][N];
        tomatoForCheck = new ArrayList<>();
        answer = 0;
        totalTomato = 0;
        
        for(int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                tomato[i][j] = Integer.parseInt(inputs[j]);

                if(tomato[i][j] == 1) {
                    tomatoForCheck.add(new Point(i, j));
                }
                
                if(tomato[i][j] == 0) totalTomato++;
            }
        }

        System.out.println(bfs());

    }

    public static int bfs() {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        List<Point> tmp;

        while(!tomatoForCheck.isEmpty()) {
            int nx, ny = 0;
            tmp = new ArrayList<>();
            for(Point now : tomatoForCheck) {
                for(int i = 0; i < 4; i++) {
                    nx = dx[i] + now.x;
                    ny = dy[i] + now.y;

                    if (0 <= nx && nx < M && 0 <= ny && ny < N && tomato[nx][ny] == 0) {
                        tomato[nx][ny] = 1;
                        totalTomato--;
                        tmp.add(new Point(nx, ny));
                    }
                }
            }
            if (tmp.isEmpty()) break;
            answer++;
            tomatoForCheck = new ArrayList<>();
            tomatoForCheck.addAll(tmp);
        }

        if (totalTomato != 0) return -1;
        return answer;
    }
}
