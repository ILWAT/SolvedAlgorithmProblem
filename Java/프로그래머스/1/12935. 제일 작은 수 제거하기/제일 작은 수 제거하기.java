import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length <= 1) {
            return new int[]{-1};
        }
        
        int minValue = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }
        
        int[] answer = new int[arr.length - 1];
        int index = 0;
        for (int a : arr) {
            if (a == minValue) continue;
            answer[index++] = a; 
        }
        
        return answer;
    }
}