import java.io.*;

public class Main {
    static int[] lis;
    static int[] arr;
    public static int binarySearch(int left, int right, int target) {
        int mid = 0;
        while(left<right) {
            mid = (left+right)/2;
            if(lis[mid] < target) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        arr = new int[n+1];
        lis = new int[n+1];
        String[] inputs = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }
        lis[0] = arr[0];

        int j = 0;
        int i = 1;
        while(i<n) {
            if (lis[j] < arr[i]) {
                lis[j+1] = arr[i];
                j++;
            } else {
                int pos = binarySearch(0, j, arr[i]);
                lis[pos] = arr[i];
            }
            i++;
        }

        System.out.println(j+1);
    }
}