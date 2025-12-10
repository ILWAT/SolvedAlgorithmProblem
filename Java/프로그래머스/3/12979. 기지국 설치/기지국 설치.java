class Solution {
    public int solution(int n, int[] stations, int w) {
        int lastestIndex = 0;
        int currentApt = 1;
        int answer = 0;
        
        while (currentApt <= n) {
            if (lastestIndex < stations.length && currentApt >= stations[lastestIndex] - w) {
                currentApt = stations[lastestIndex++] + w + 1;
            } else {
                currentApt += (w * 2) + 1;
                answer++;
            }
        }

        return answer;
    }
}