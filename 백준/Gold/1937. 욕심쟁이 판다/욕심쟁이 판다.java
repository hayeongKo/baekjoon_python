// 1937
// 욕심쟁이 판다
import java.io.*;

public class Main {
    static int N;
    static int[][] forest;
    static boolean[][] visited;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        forest = new int[N][N];
        visited = new boolean[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                forest[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int res = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, dfs(i, j));
            }
        }
        System.out.println(res);
    }

    public static int dfs(int x, int y) {

        if (dp[x][y] != 0) { // 이미 방문했다면
            return dp[x][y];
        }

        dp[x][y] = 1;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                if(forest[nx][ny] > forest[x][y]) {
                    dp[x][y] = Math.max(dp[x][y], dfs(nx, ny)+1);
                } 
            }
        }
        return dp[x][y];
    }
}