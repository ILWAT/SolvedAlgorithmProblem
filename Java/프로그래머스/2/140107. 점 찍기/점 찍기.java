class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (long x = 0; x<= d; x += k) {
            long dSquared = (long) d * d;
            long xSquared = x * x;
            
            double maxY = Math.sqrt(dSquared - xSquared);
            
            answer += ((long)(maxY / k)) + 1;
        }
        return answer;
    }
}