class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long p = numbers[i];
            if ((p & 3) != 3) {
                answer[i] = p + 1;
            } else {
                long combined = (p + 1) | p;
                long changed = combined ^ p;
                answer[i] = ~(changed >> 1) & combined;
            }
        }
        return answer;
    }
}