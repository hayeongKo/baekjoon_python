import java.util.*;

class Solution {
    int rsx, rsy, bsx, bsy;
    int rdx, rdy, bdx, bdy;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int N, M;
    int[][] maze;
    class State {
        int rx, ry, bx, by;
        boolean[][] rVisited, bVisited;
        int dist, turn;
        State(int rx, int ry, int bx, int by, boolean[][] rVisited, boolean[][] bVisited, int dist, int turn) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.rVisited = rVisited;
            this.bVisited = bVisited;
            this.dist = dist;
            this.turn = turn;
        }
    }
    
    public int solution(int[][] maze) {
        int answer = 0;
        this.N = maze.length;
        this.M = maze[0].length;
        this.maze = maze;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if (maze[i][j] == 1) {
                    rsx = i;
                    rsy = j;
                } else if (maze[i][j] == 2) {
                    bsx = i;
                    bsy = j;
                } else if (maze[i][j] == 3) {
                    rdx = i;
                    rdy = j;
                } else if (maze[i][j] == 4) {
                    bdx = i;
                    bdy = j;
                }
            }
        }
        
        return bfs();
    }
    
    public int bfs() {
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt((State s) -> s.turn));
        boolean[][] prVisited = new boolean[N][M];
        boolean[][] pbVisited = new boolean[N][M];
        prVisited[rsx][rsy] = true;
        pbVisited[bsx][bsy] = true;
        
        int pdist = getDist(rsx, rsy, bsx, bsy, prVisited, pbVisited);
        if (pdist == -1) return 0;
        
        State state = new State(rsx, rsy, bsx, bsy, prVisited, pbVisited, pdist, 0);
        pq.offer(state);
        while(!pq.isEmpty()) {
            State cur = pq.poll();
            int rx = cur.rx;
            int ry = cur.ry;
            int bx = cur.bx;
            int by = cur.by;
            // System.out.println("rx: " + rx + " ry: " + ry + " bx: " + bx + " by: " + by);
            boolean[][] rVisited = cur.rVisited;
            boolean[][] bVisited = cur.bVisited;
            int dist = cur.dist;
            int turn = cur.turn;
            
            if (dist == 0) {
                return turn;
            }
            
            if (!arriveRed(rx, ry) && !arriveBlue(bx, by)) {
                for(int i = 0; i < 4; i++) {
                    int nrx = rx+dx[i];
                    int nry = ry+dy[i];
                    if (inRange(nrx, nry) && !rVisited[nrx][nry] && maze[nrx][nry] != 5) {
                        boolean[][] nrVisited = copyVisited(rVisited);
                        nrVisited[nrx][nry]=true;
                        // System.out.println("nr: " + nrx + " " + nry);
                        for(int j = 0; j < 4; j++) {
                            int nbx = bx+dx[j];
                            int nby = by+dy[j];
                            if (inRange(nbx, nby) && !bVisited[nbx][nby] && maze[nbx][nby]!=5 && (nbx != nrx || nby != nry) 
                                && !((nrx == bx && nry == by) && (nbx == rx && nby == ry))) {
                                // System.out.println("nb: " + nbx + " " + nby);
                                boolean[][] nbVisited = copyVisited(bVisited);
                                nbVisited[nbx][nby] = true;
                                int nDist = getDist(nrx, nry, nbx, nby, nrVisited, nbVisited);
                                if (nDist == -1) continue;
                                pq.offer(new State(nrx, nry, nbx, nby, nrVisited, nbVisited, nDist, turn+1));
                            }
                        }
                    }
                }
            } else if (arriveRed(rx, ry) && !arriveBlue(bx, by)) {
                int nrx = rx;
                int nry = ry;
                for(int j = 0; j < 4; j++) {
                    int nbx = bx+dx[j];
                    int nby = by+dy[j];
                    if (inRange(nbx, nby) && !bVisited[nbx][nby] && maze[nbx][nby]!=5 && (nbx != nrx || nby != nry)) {
                        // System.out.println("nb: " + nbx + " " + nby);
                        boolean[][] nrVisited = copyVisited(rVisited);
                        boolean[][] nbVisited = copyVisited(bVisited);
                        nbVisited[nbx][nby] = true;
                        int nDist = getDist(nrx, nry, nbx, nby, nrVisited, nbVisited);
                        if (nDist == -1) continue;
                        pq.offer(new State(nrx, nry, nbx, nby, nrVisited, nbVisited, nDist, turn+1));
                    }
                }
            } else if(!arriveRed(rx, ry) && arriveBlue(bx, by)) {
                int nbx = bx;
                int nby = by;
                for(int j = 0; j < 4; j++) {
                    int nrx = rx+dx[j];
                    int nry = ry+dy[j];
                    if (inRange(nrx, nry) && !rVisited[nrx][nry] && maze[nrx][nry]!=5 && (nrx != nbx || nry != nby)) {
                        // System.out.println("nb: " + nbx + " " + nby);
                        boolean[][] nrVisited = copyVisited(rVisited);
                        boolean[][] nbVisited = copyVisited(bVisited);
                        nbVisited[nrx][nry] = true;
                        int nDist = getDist(nrx, nry, nbx, nby, nrVisited, nbVisited);
                        if (nDist == -1) continue;
                        pq.offer(new State(nrx, nry, nbx, nby, nrVisited, nbVisited, nDist, turn+1));
                    }
                }
            }
        }
        
        return 0;
    }
    
    public boolean arriveRed(int rx, int ry) {
        return rx == rdx && ry == rdy;
    }
    
    public boolean arriveBlue(int bx, int by) {
        return bx == bdx && by == bdy;
    }
    
    public int getDist(int rx, int ry, int bx, int by, boolean[][] rVisited, boolean[][] bVisited) {
        int redDist = -1;
        int blueDist = -1;
        
        boolean[][] visited = copyVisited(rVisited);
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{rx, ry, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            if (x == rdx && y == rdy) {
                redDist = d;
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if (inRange(nx, ny) && maze[nx][ny]!=5 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, d+1});
                }
            }
        }
        
        if (redDist == -1) return -1;
        
        visited = copyVisited(bVisited);
        q = new ArrayDeque<>();
        q.offer(new int[]{bx, by, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            if (x == bdx && y == bdy) {
                blueDist = d;
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if (inRange(nx, ny) && maze[nx][ny]!=5 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, d+1});
                }
            }
        }
        
        if (blueDist == -1) return -1;
        return redDist+blueDist;
    }
    
    public boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    
    public boolean[][] copyVisited(boolean[][] visited) {
        boolean[][] res = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                res[i][j] = visited[i][j];
            }
        }
        return res;
    }
}