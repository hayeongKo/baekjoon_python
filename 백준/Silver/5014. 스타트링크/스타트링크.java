import java.util.*;
import java.io.*;

public class Main {
    static int F, S, G, U, D;
    static boolean[] visited;
    static int ans;

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

        F = Integer.parseInt(inputs[0]);
        S = Integer.parseInt(inputs[1]);
        G = Integer.parseInt(inputs[2]);
        U = Integer.parseInt(inputs[3]);
        D = Integer.parseInt(inputs[4]);
        ans = Integer.MAX_VALUE;
        visited = new boolean[F+1];

        bfs(S);

        if (ans == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
        } else {
            System.out.println(ans);
        }
    }

    public static void bfs(int v) {
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(v, 0));
        visited[v] = true;

        while(!queue.isEmpty()) {
            Point now = queue.pop();
            int x = now.x;
            if (x == G) {
                ans = Math.min(ans, now.d);
                return;
            }

            if (x+U > 0 && x+U <= F && !visited[x+U]) {
                visited[x+U] = true;
                queue.offer(new Point(x+U, now.d+1));
            }

            if (x-D > 0 && x-D <= F && !visited[x-D]) {
                visited[x-D] = true;
                queue.offer(new Point(x-D, now.d+1));
            }
        }
    }
}
