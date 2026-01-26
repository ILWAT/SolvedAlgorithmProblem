class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int remaind = storey % 10;
            int nextDigit = (storey / 10) % 10;
            
            if (remaind > 5) {
                answer += (10 - remaind);
                storey = (storey / 10) + 1;
            } else if (remaind < 5) {
                answer += remaind;
                storey /= 10;
            } else {
                answer += 5;
                if (nextDigit >= 5) {
                    storey = (storey / 10) + 1;
                } else {
                    storey /= 10;
                }
            }
        }
        return answer;
    }
}