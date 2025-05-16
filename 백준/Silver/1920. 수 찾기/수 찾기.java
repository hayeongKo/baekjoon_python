import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] nums;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        
        String[] inputs = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(nums);
        
        int M = Integer.parseInt(br.readLine());
        inputs = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(inputs[i]);
            System.out.println(bs(target));
        }
    }
    
    public static int bs(int target) {
        int left = 0;
        int right = N-1;
        
        while(left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] == target) {
                return 1;
            } else if (nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return 0;
    }
}