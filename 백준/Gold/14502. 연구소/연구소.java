import java.util.*;
import java.io.*;

public class Main {
    static int[][] lab;
    static int[][] nlab;
    static int N, M;
    static List<Point> empty;
    static List<Point> virus;
    static class Point{
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
        lab = new int[N][M];
        nlab = new int[N][M];
        virus = new ArrayList<>();
        empty = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(inputs[j]);
                if (lab[i][j] == 0) {
                    empty.add(new Point(i, j));
                } else if (lab[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < empty.size()-2; i++) {
            for(int j = i+1; j < empty.size()-1; j++) {
                for(int k = j+1; k < empty.size(); k++) {
                    lab[empty.get(i).x][empty.get(i).y] = 1;
                    lab[empty.get(j).x][empty.get(j).y] = 1;
                    lab[empty.get(k).x][empty.get(k).y] = 1;
                    answer = Math.max(spread(), answer);
                    lab[empty.get(i).x][empty.get(i).y] = 0;
                    lab[empty.get(j).x][empty.get(j).y] = 0;
                    lab[empty.get(k).x][empty.get(k).y] = 0;
                }
            }
        }
        System.out.println(answer);
    }

    public static int spread() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                nlab[i][j] = lab[i][j];
            }
        }

        ArrayDeque<Point> queue = new ArrayDeque<>(virus);
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int nx, ny;
        while(!queue.isEmpty()) {
            Point now = queue.pop();
            for(int i = 0; i < 4; i++) {
                nx = now.x + dx[i];
                ny = now.y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M && nlab[nx][ny] == 0) {
                    nlab[nx][ny] = 2;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

        int res = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (nlab[i][j] == 0) res++;
            }
        }
        return res;
    }
}