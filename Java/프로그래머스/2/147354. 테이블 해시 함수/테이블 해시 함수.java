import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (a1, a2) -> {
            if (a1[col - 1] != a2[col - 1]) {
                return Integer.compare(a1[col - 1], a2[col - 1]);
            }
            return Integer.compare(a2[0], a1[0]);
        });
        int count = row_end - row_begin + 1;
        int[] arr = new int[count];
        int index = 0;
        for (int i = row_begin; i <= row_end; i++) {
            int currentIndex = i - 1;
            for (int j = 0; j < data[currentIndex].length; j++) {
                arr[index] += data[currentIndex][j] % i;
            }
            index++;
        }
        
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            answer = answer ^ arr[i];
        }
        
        return answer;
    }
}