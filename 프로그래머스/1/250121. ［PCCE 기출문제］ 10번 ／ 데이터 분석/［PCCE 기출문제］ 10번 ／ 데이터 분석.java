import java.util.*;

class Solution {
    public int[][] solution(int[][] dataList, String ext, int val_ext, String sort_by) {
        String[] colName = {"code", "date", "maximum", "remain"};
        
        int extCol = 0;
        int sortByCol = 0;
        
        for(int i = 0; i < 4; i++) {
            if(ext.equals(colName[i])) extCol = i;
            if(sort_by.equals(colName[i])) sortByCol = i;
        }
        
        List<int[]> filteringData = new ArrayList<>();
        
        for(int[] data : dataList) {
            if (data[extCol] < val_ext) filteringData.add(data);
        }
        
        int[][] finalData = new int[filteringData.size()][4];
        
        int k = 0;
        for(int[] data : filteringData) {
            finalData[k++] = data;
        }
        
        final int sortById = sortByCol;
        
        Arrays.sort(finalData, Comparator.comparingInt(a -> a[sortById]));
        return finalData;
        
    }
}