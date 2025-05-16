import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        
        inputs = br.readLine().split(" ");
        int[] nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }
        
        int cnt = 0;
        int sum = 0;
        int start = 0, end = 0;
        while(true) {
            if (sum >= M) {
                sum -= nums[start++];
            } else if (end == N) {
                break;
            } else {
                sum += nums[end++];
            }
            
            if (sum == M) cnt++;
        }
        
        System.out.println(cnt);
    }
}