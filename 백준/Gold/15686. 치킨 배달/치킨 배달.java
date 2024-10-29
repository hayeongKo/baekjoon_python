// 15686
// 치킨배달 

import java.io.*;
import java.util.*;

public class Main {
    static class Pos {
        int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N,M;
    static int[][] city;
    static List<Pos> chickens;
    static List<Pos> houses;
    static int res;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        chickens = new ArrayList<>();
        houses = new ArrayList<>();
        city = new int[N][N];

        // 초기화
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(inputs[j]);
                if (city[i][j] == 2) {
                    chickens.add(new Pos(i, j));
                } else if(city[i][j] == 1) {
                    houses.add(new Pos(i, j));
                }
            }
        }

        visited = new boolean[chickens.size()];
        res = Integer.MAX_VALUE;

        dfs(0, 0);
        System.out.println(res);
    }

    public static void dfs(int depth, int start) {
        if (depth == M) {
            int totalD = 0;
            for (int i = 0; i < houses.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < chickens.size(); j++) {
                    if (visited[j]) {
                        int d = (int) Math.abs(houses.get(i).x-chickens.get(j).x) + Math.abs(houses.get(i).y-chickens.get(j).y);
                        temp = Math.min(temp, d);
                    }
                }
                totalD += temp;
            }
            res = Math.min(totalD, res);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            visited[i] = true;
            dfs(depth+1, i+1);
            visited[i] = false;
        }
    }
}