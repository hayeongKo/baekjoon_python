// 12015
// 가장 긴 증가하는 부분 수열 2

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static ArrayList<Integer> lis;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        lis = new ArrayList<>();

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }
        
        
        lis.add(arr[0]); // 일단 가장 긴 수열에 첫번째 요소를 넣고 시작

        for (int i = 1; i < N; i++) {
            if (arr[i] > lis.get(lis.size()-1)) { // 만약 lis의 마지막 요소보다 arr가 크면 수열에 추가
                lis.add(arr[i]);
            } else { // 만약 반대의 경우
                int pos = bisect(arr[i]);
                lis.set(pos, arr[i]);
            }
        }
        
        System.out.println(lis.size());
    }

    public static int bisect(int target) {
        int left = 0;
        int right = lis.size()-1;

        while (left < right) {
            int mid =(left+right)/2;
            if (lis.get(mid) >= target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return right;
    }
}
