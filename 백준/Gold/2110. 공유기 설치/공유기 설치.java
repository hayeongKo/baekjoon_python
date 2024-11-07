// 2110
// 공유기 설치

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Long> house;
    static int C, N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);
        house = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            house.add(Long.parseLong(br.readLine()));
        }

        Collections.sort(house);

        long left = 1; // 가능한 최소 거리
        long right = house.get(N-1)-house.get(0); // 가능한 최대 거리

        long res = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            // 공유기를 C개 만큼 설치 가능?
            if (check(mid)) {
                // 설치 가능 -> 가장 인접한 두 공유기 사이의 거리를 최대로 해야함 -> 더 커져도 되는지 확인
                res = Math.max(res, mid);
                left = mid + 1;
            } else {
                // 설치 불가능 -> 현재 거리가 너무 멀다는 거니까 오른쪽 줄이기
                right = mid - 1;
            }
        }

        System.out.println(res);
    }

    public static boolean check(long dist) {
        long cnt = 1;
        long prev = house.get(0);

        for (int i = 1; i < N; i++) {
            if (house.get(i) - prev >= dist) { // 집 간의 거리가 설정한 최소 거리보다 크면 공유기 설치 가능
                cnt++;
                prev = house.get(i);
            }
        }

        return cnt >= C;
    }
}