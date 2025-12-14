class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for (long x = 1; x <= r2; x++) {
            int yMax = (int) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2)));
            int yMin = (int) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2)));

            answer += (yMax - yMin + 1);
        }
        
        
        return (answer * 4);
    }
}