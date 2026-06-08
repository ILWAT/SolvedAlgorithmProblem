class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dxySet = new int[][]{{-1, 0}, {0, -1}};
        int[][] dp = new int[n][m];
        for (int[] puddle : puddles) {
            int y = puddle[1] - 1;
            int x = puddle[0] - 1;
            dp[y][x] = -1; 
        }
        
        dp[0][0] = 1;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if ((x == 0 && y == 0) || dp[y][x] == -1) continue;
                
                int top = 0;
                int left = 0;
                
                if (y - 1 >= 0 && dp[y - 1][x] != -1) {
                    top = dp[y - 1][x];
                } 
                
                if (x - 1 >= 0 && dp[y][x - 1] != -1) {
                    left = dp[y][x - 1];
                }
                
                dp[y][x] = (top + left) % 1000000007;
            }
        }
        
        return dp[n-1][m-1];
    }
}