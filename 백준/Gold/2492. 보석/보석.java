import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T, K;
    static List<int[]> attacks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        attacks = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            attacks.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        
        int maxCount = 0;
        int[] maxPos = new int[2];

        // 모든 공격 지점을 순회하며 후보 정사각형의 x, y 좌표를 결정
        for (int[] p1 : attacks) {
            for (int[] p2 : attacks) {
                // 후보 정사각형의 왼쪽 상단 x, y 좌표
                int candidateX = p1[0];
                int candidateY = p2[1];

                // 경계 내에 있는지 확인
                if (candidateX < 0) candidateX = 0;
                if (candidateY < 0) candidateY = 0;
                
                int endX = candidateX + K;
                int endY = candidateY + K;
                
                if (endX > N) {
                    candidateX = N - K;
                    endX = N;
                }
                
                if (endY > M) {
                    candidateY = M - K;
                    endY = M;
                }
                
                int currentCount = 0;
                // 모든 공격 지점을 순회하며 정사각형 안에 포함되는지 확인
                for (int[] p : attacks) {
                    if (p[0] >= candidateX && p[0] <= endX && p[1] >= candidateY && p[1] <= endY) {
                        currentCount++;
                    }
                }
                
                // 최대값 갱신
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    maxPos[0] = candidateX;
                    maxPos[1] = endY; // y좌표는 y+K를 사용
                }
            }
        }
        
        System.out.println(maxPos[0] + " " + maxPos[1]);
        System.out.println(maxCount);
    }
}