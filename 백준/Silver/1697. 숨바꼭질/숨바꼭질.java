import java.util.*;
import java.io.*;

public class Main {
    static int N, K, ans;
    static boolean[] visited;

    static class Point {
        int x, d;
        Point(int x, int d) {
            this.x = x;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);
        visited = new boolean[1000001];
        bfs(N);
        System.out.print(ans);
    }

    public static void bfs(int v) {
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(v, 0));
        visited[v] = true;

        while(!queue.isEmpty()) {
            Point now = queue.pop();
            int x = now.x;
            if (x == K) {
                ans = now.d;
                return;
            }
            if (2*x >= 0 && 2*x <= 100000 && !visited[2*x]) {
                visited[2*x] = true;
                queue.offer(new Point(2*x, now.d+1));
            }

            if (x+1 >= 0 && x+1 <= 100000 && !visited[x+1]) {
                visited[x+1] = true;
                queue.offer(new Point(x+1, now.d+1));
            }

            if (x-1 >= 0 && x-1 <= 100000 && !visited[x-1]) {
                visited[x-1] = true;
                queue.offer(new Point(x-1, now.d+1));
            }
        }
    }
}