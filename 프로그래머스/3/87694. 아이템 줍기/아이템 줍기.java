import java.util.*;

class Solution {
    int N;
    int[][] rectangles;
    boolean[][] roads;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        N = rectangle.length;
        for(int i = 0; i < N; i++) {
            rectangle[i] = new int[]{rectangle[i][0]*2, rectangle[i][1]*2, rectangle[i][2]*2, rectangle[i][3]*2};
        }
        
        rectangles = rectangle;
        roads = new boolean[101][101];
        checkInRange();

        
        return bfs(characterX*2, characterY*2, itemX*2, itemY*2)/2;
    }
    
    public int bfs(int characterX, int characterY, int itemX, int itemY) {
        boolean[][] visited = new boolean[101][101];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            if (x==itemX && y==itemY) return d;
            
            for(int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                int[] next = new int[]{nx, ny};
                if (inRange(nx, ny) && roads[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, d+1});
                }
            }
        }
        
        return -1;
    }
    
    public void checkInRange() {
        for(int i = 0; i < N; i++) {
            // x 좌표 범위
            int[] target = rectangles[i];
            
            for(int x = target[0]; x <= target[2]; x++) {
                boolean flag1 = false;
                boolean flag2 = false;
                
                for(int j = 0; j < N; j++) {
                    if (i == j) continue;
                    int[] check = rectangles[j];
                    if (inShape(x, target[1], check[0], check[1], check[2], check[3])) {
                        flag1 = true;
                        break;
                    }
                }
                if (!flag1) roads[x][target[1]] = true;
                
                for(int j = 0; j < N; j++) {
                    if (i == j) continue;
                    int[] check = rectangles[j];
                    if (inShape(x, target[3], check[0], check[1], check[2], check[3])) {
                        flag2 = true;
                        break;
                    }
                }
                if (!flag2) roads[x][target[3]] = true;
            }
        }
        
        for(int i = 0; i < N; i++) {
            // y 좌표 범위
            int[] target = rectangles[i];
            
            for(int y = target[1]; y <= target[3]; y++) {
                boolean flag1 = false;
                boolean flag2 = false;
                for(int j = 0; j < N; j++) {
                    if (i == j) continue;
                    int[] check = rectangles[j];
                    if (inShape(target[0], y, check[0], check[1], check[2], check[3])) {
                        flag1 = true;
                        break;
                    }
                }
                if (!flag1) roads[target[0]][y] = true;
                
                for(int j = 0; j < N; j++) {
                    if (i == j) continue;
                    int[] check = rectangles[j];
                    if (inShape(target[2], y, check[0], check[1], check[2], check[3])) {
                        flag2 = true;
                        break;
                    }
                }
                
                if (!flag2) {
                    roads[target[2]][y] = true;
                }
            } 
        }
    }
    
    public boolean inRange(int x, int y) {
        return x >= 0 && x <= 100 && y >= 0 && y <= 100;
    }
    public boolean inShape(int x, int y, int sx, int sy, int dx, int dy) {
        return sx < x && x < dx && sy < y && y < dy;
    }
}