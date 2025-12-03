class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        for (int i = 1; i<land.length; i++) {
            for (int j = 0; j<land[i].length; j++) {
                int max = 0;
                for (int x = 0; x<land[i].length; x++) {
                    if (x == j) continue;
                    max = Math.max(max, land[i-1][x]);
                }
                land[i][j] += max;
            }
        }

        int lastRow = land.length-1;
        for (int i = 0; i<4; i++) {
            answer = Math.max(answer, land[lastRow][i]);
        }
        return answer;
    }
}