import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] soccerTeam;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;

        soccerTeam = new int[N][N];
        for(int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                soccerTeam[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        dfs(new int[N/2], new int[N/2], 0, 0, 0);

        System.out.println(ans);
    }

    public static void dfs(int[] start, int[] link, int startCnt, int linkCnt, int depth) {
        
        if (depth == N) {
            int startScore = 0, linkScore = 0;

            for(int i = 0; i < N/2-1; i++) {
                for(int j = i+1; j < N/2; j++) {
                    startScore += soccerTeam[start[i]][start[j]] + soccerTeam[start[j]][start[i]];
                    linkScore += soccerTeam[link[i]][link[j]] + soccerTeam[link[j]][link[i]];
                }
            }

            ans = Math.min(Math.abs(startScore-linkScore), ans);
            return;
        }

        if (startCnt < N/2) {
            start[startCnt] = depth;
            dfs(start, link, startCnt+1, linkCnt, depth+1);
            start[startCnt] = 0;
        }

        if (linkCnt < N/2) {
            link[linkCnt] = depth;
            dfs(start, link, startCnt, linkCnt+1, depth+1);
            link[linkCnt] = 0;
        }
        

    }
}