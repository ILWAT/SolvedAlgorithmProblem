import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
       List<String> order = Arrays.asList("code", "date", "maximum", "remain");
        
        int extIndex = order.indexOf(ext);
        int sort_by_Index = order.indexOf(sort_by);
        
        ArrayList<int[]> al = new ArrayList<>();
        
        for (int[] element : data) {
            if (element[extIndex] < val_ext) {
                al.add(element);
            }
        }
        
        Collections.sort(al, (a, b) -> Integer.compare(a[sort_by_Index], b[sort_by_Index]));
        
        int[][] answer = new int[al.size()][order.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = al.get(i);
        }
        
        return answer;
    }
}