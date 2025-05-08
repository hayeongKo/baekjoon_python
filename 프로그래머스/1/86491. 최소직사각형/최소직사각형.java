class Solution {
    public int solution(int[][] sizes) {
        int width = Integer.MIN_VALUE;
        int height = Integer.MIN_VALUE;
        
        for(int[] size : sizes) {
            if (size[0] < size[1]) {
                width = Math.max(size[1], width);
                height = Math.max(size[0], height);
            } else {
                width = Math.max(size[0], width);
                height = Math.max(size[1], height);
            }
        }
        return width*height;
    }
}