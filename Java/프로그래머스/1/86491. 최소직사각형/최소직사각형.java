class Solution {
    public int solution(int[][] sizes) {
        int maxValue = 0;
        int minValue = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int currentW = sizes[i][0];
            int currentH = sizes[i][1];
            int currentMax = Math.max(currentW, currentH);
            int currentMin = Math.min(currentW, currentH);
            
            maxValue = Math.max(maxValue, currentMax);
            minValue = Math.max(minValue, currentMin);
        }
        
        return maxValue * minValue;
    }
}