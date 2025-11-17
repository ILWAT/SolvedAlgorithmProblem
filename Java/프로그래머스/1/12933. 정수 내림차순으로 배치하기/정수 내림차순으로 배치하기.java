class Solution {
    public long solution(long n) {
        int[] arr = new int[10];
        while (n > 0) {
            arr[(int)(n%10)]++;
            n /= 10;
        }
        
        long answer = 0;
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j<arr[i]; j++) {
                answer += i;
                answer *= 10;
            }
        }
        return answer / 10;
    }
}