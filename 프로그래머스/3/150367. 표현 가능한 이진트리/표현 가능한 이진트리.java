class Solution {
    int N;
    public int[] solution(long[] numbers) {
        int[] ans = new int[numbers.length];

        int idx = 0;
        for(long number : numbers) {
            String binaryNum = Long.toBinaryString(number);
            int currentLength = binaryNum.length();

        int treeSize = 1;
        while (treeSize < currentLength) {
            treeSize = treeSize*2+1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < treeSize - currentLength; i++) {
        sb.append('0');
        }
        sb.append(binaryNum);
        binaryNum = sb.toString();
        N = treeSize;
        ans[idx++] = dfs(binaryNum, N/2, 0, N-1) ? 1 : 0;
    }
    return ans;
}
    
public boolean dfs(String num, int root, int start, int end) {
    // System.out.println(start+" "+root+" "+end);
    if (start > end || start == end) {
        return true;
    }
    
    int left = (start+root-1)/2;
    int right = (root+1+end)/2;
    
    if (num.charAt(root) == '0') {
        if (num.charAt(left) == '1' || num.charAt(right) == '1') return false;
    }

    boolean flag1 = true;
    boolean flag2 = true;
    flag1 = dfs(num, left, start, root-1);
    flag2 = dfs(num, right, root+1, end);

    return flag1&&flag2;
}
}