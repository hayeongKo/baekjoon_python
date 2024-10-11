// 11054
// 가장 긴 바이토닉 부분 수열

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        int[] arr = new int[N];

        int[] front = new int[N];
        int[] rear = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        // 계속 증가하는 부분
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && front[i] < front[j]) {
                    front[i] = front[j];
                }
            }
            front[i]++;
        }

        // 뒤에서부터 증가하는 부분 확인
        for(int i = N-1; i >= 0; i--) {
            for(int j = N-1; j > i; j--) {
                if(arr[i] > arr[j] && rear[i] < rear[j]) {
                    rear[i] = rear[j];
                }
            }
            rear[i]++;
        }

        int res = 0;
        for(int i = 0; i < N; i++) {
            res = Math.max(res, front[i]+rear[i]-1);
        }

        System.out.println(res);
    }
}