import java.util.Arrays;

class Solution {
    static private int getResult(int[] array, int[] command) {
        int i = command[0]-1;
        int j = command[1]-1;
        int k = command[2]-1;
        
        int[] result = new int[j-i+1];
        int resultIndex = 0;
        for (int index = i; index<=j; index++) {
            result[resultIndex++] = array[index];
        }
        
        Arrays.sort(result);
        
        return result[k];        
    }
    
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int resultIndex = 0;
        
        for (int[] command : commands) {
            answer[resultIndex++] = getResult(array, command);
        }
        return answer;
    }
}