class Solution {
    private int answer = 0;
    public int solution(int[] numbers, int target) {
        answer = 0;
        stacked(numbers, target, 0, 0);
        return answer;
    }
    
    private void stacked(int[] numbers, int target, int index, int sum) {
        if (numbers.length == index) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        stacked(numbers, target, index + 1, sum + numbers[index]);
        stacked(numbers, target, index + 1, sum - numbers[index]);
    }
}