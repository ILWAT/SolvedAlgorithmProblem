class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for (int item : arr) {
            answer += item;
        }
        
        answer /= arr.length;
        
        return answer;
    }
}