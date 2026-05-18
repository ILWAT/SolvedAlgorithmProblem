class Solution {
    public int solution(int[] citations) {
        int max = 0;
        int length = citations.length;
        int[] countArr = new int[10001];
        for (int citation : citations) {
            max = Math.max(max, citation);
            for (int i = 0; i <= citation; i++) {
                countArr[i] += 1;
            }
        }
        
        int answer = 0;
        for (int i = max; i >= 0; i--) {
            if ((countArr[i] >= i) && (length - countArr[i] <= i)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}