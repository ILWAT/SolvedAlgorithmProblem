class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
            int receiveBottle = (n/a) * b;
            answer += receiveBottle;
            n = (n % a) + receiveBottle;
        }
        return answer;
    }
}