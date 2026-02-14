class Solution {
    public int solution(int[] number) {
        int answer = 0;
        for (int sIndex = 0; sIndex < number.length-2; sIndex++) {
            for (int mIndex = sIndex+1; mIndex < number.length-1; mIndex++) {
                for (int eIndex = mIndex+1; eIndex < number.length; eIndex++) {
                    int sum = number[sIndex] + number[mIndex] + number[eIndex];
                    if (sum == 0) answer++;
                }
            }
        }
        
        return answer;
    }
}