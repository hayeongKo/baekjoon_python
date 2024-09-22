// 2667
// 단지번호붙이기

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] houses;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        houses = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                houses[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int newComplex = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (!visited[i][j] && houses[i][j] != 0) {
                    newComplex++;
                    int oldComplex = houses[i][j];
                    dfs(i, j, oldComplex, newComplex);
                }
            }
        }

        int[] answer = new int[newComplex+1];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (houses[i][j] == 0) {
                    continue;
                }
                answer[houses[i][j]]++;
            }
        }

        Arrays.sort(answer);

        System.out.println(newComplex);
        for(int ans : answer) {
            if (ans == 0) {
                continue;
            }
            System.out.println(ans);
        }
    }

    public static void dfs(int x, int y, int oldComplex, int newComplex) {
        if (0 <= x && x < N && 0 <= y && y < N && !visited[x][y]) {
            if (houses[x][y] == oldComplex) {
                houses[x][y] = newComplex;
                visited[x][y] = true;
                dfs(x+1, y, oldComplex, newComplex);
                dfs(x-1, y, oldComplex, newComplex);
                dfs(x, y+1, oldComplex, newComplex);
                dfs(x, y-1, oldComplex, newComplex);
            }
        }
    }
}
