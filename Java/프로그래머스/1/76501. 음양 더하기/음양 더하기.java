class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        for (int i = 0; i < absolutes.length; i++) {
            int signedNum;
            if (signs[i]) {
                signedNum = absolutes[i];
            } else {
                signedNum = -absolutes[i];
            }
            sum += signedNum;
        }
        
        return sum;
    }
}