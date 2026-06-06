class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int number : arr) {
            answer = (answer * number) / euclid(number, answer);
        }
        
        return answer;
    }
    
    private int euclid(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}