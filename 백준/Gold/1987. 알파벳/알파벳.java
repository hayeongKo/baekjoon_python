import java.util.*;
import java.io.*;

public class Main {
    static int R, C, res;
    static String[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        R = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);
        map = new String[R+1][C+1];
        res = 0;

        for(int i = 1; i <= R; i++) {
            inputs = br.readLine().split("");
            for(int j = 1; j <= C; j++) {
                map[i][j] = inputs[j-1];
            }
        }

        HashMap<String, Integer> visited = new HashMap<>();
        visited.put(map[1][1], 1);
        dfs(1, 1, 1, visited);
        System.out.println(res);

    }

    public static void dfs(int x, int y, int d, HashMap<String, Integer> visited) {
        res = Math.max(res, d);
        visited.put(map[x][y], 1);

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int nx, ny = 0;
        for(int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx > 0 && nx <= R && ny > 0 && ny <= C && !visited.containsKey(map[nx][ny])) {
                dfs(nx, ny, d+1, visited);
            }
        }
        visited.remove(map[x][y]);
    }

}