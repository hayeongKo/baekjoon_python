import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int x, y, cost, key;
        public Node(int x, int y, int cost, int key) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.key = key;
        }
    }
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] board;
    static int N, M;
    static Node start;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == '0') start = new Node(i, j, 0, 0);
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][64];
        q.offer(start);
        visited[start.x][start.y][0] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (board[cur.x][cur.y] == '1') return cur.cost;

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!inRange(nx, ny)) continue;
                if (visited[nx][ny][cur.key] || board[nx][ny] == '#') continue;

                if (board[nx][ny] >= 'a' && board[nx][ny] <= 'f') {
                    int nk = 1 << (board[nx][ny]-'a');
                    nk = cur.key | nk;
                    visited[nx][ny][nk] = true;
                    q.offer(new Node(nx, ny, cur.cost+1, nk));
                } else if (board[nx][ny] >= 'A' && board[nx][ny] <= 'F') {
                    if ((cur.key & 1 << (board[nx][ny] - 'A')) == (int)Math.pow(2, board[nx][ny]-'A')) {
                        visited[nx][ny][cur.key] = true;
                        q.offer(new Node(nx, ny, cur.cost+1, cur.key));
                    }
                } else {
                    visited[nx][ny][cur.key] = true;
                    q.offer(new Node(nx, ny, cur.cost+1, cur.key));
                }
            }
        }

        return -1;
    }

    public static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}
