class Solution {
    public int[] solution(int brown, int yellow) {
        int totalSize = brown + yellow;
        int columnMax = (int)Math.sqrt(totalSize);
        for (int vertical = 3; vertical <= columnMax; vertical++) {
            if (totalSize % vertical == 0) {
                int horizon = (int)(totalSize / vertical);
                
                if (brown == (horizon + vertical -2) * 2) {
                    return new int[]{horizon, vertical};
                }
            }
        }
        return new int[]{};
    }
}