// 16235
// 나무 재테크

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] field; // 현재 양분 확인
    static int[][] fertilizer; // 나눠 줄 양분
    static ArrayList<Integer>[][] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        K = Integer.parseInt(inputs[2]);

        field =  new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                field[i][j] = 5;
            }
        }

        fertilizer = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                fertilizer[i][j] = Integer.parseInt(inputs[j-1]);
            }
        }

        trees = new ArrayList[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                trees[i][j] = new ArrayList<>();
            }
        }
        for(int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            int age = Integer.parseInt(inputs[2]);
            trees[x][y].add(age);
        }

        int year = 0;
        while (true) {
            if (year == K) {
                break;
            }

            springAndSummer();
            autumn();
            winter();
            year++;
        }

        int res = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                res += trees[i][j].size();
            }   
        }
        System.out.println(res);
    }

    public static void springAndSummer() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (trees[i][j].isEmpty()) {
                    continue;
                }

                trees[i][j].sort(Comparator.naturalOrder()); // 나이순 정렬
                ArrayList<Integer> temp = new ArrayList<>();
                Integer nutrient = 0;

                for(Integer age : trees[i][j]) {
                    if (field[i][j] >= age) {
                        field[i][j] -= age;
                        age++;
                        temp.add(age);
                    } else {
                        nutrient += age/2;
                    }
                }
                trees[i][j] = temp;
                field[i][j] += nutrient;
            }
        }
    }
    

    public static void autumn() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (trees[i][j].isEmpty()) {
                    continue;
                }

                for(Integer age : trees[i][j]) {
                    int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
                    int[] dy = {1, -1, 1, 0, -1, 1, 0, -1};
                    
                    if (age%5==0) {
                        for (int d = 0; d < 8; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
        
                            if (1 > nx || nx > N || ny < 1 || ny > N) {
                                continue;
                            }
                            
                            trees[nx][ny].add(0, 1);
                        }
                    }
                }
            }
        }
    }

    public static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                field[i][j] += fertilizer[i][j];
            }
        }
    }
}
