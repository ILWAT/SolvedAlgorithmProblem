class Solution {
    public int solution(int[][] triangle) {
        int depth = triangle.length;
        int[][] dp = new int[depth][depth];
        
        int lastRow = depth - 1;
        for (int i = 0; i < depth; i++) {
            dp[lastRow][i] = triangle[lastRow][i];
        }
        
        for (int i = depth-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j];
            }
        }
        return dp[0][0];
    }
}