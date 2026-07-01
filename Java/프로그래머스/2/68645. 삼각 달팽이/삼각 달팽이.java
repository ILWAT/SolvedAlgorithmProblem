class Solution {
    public int[] solution(int n) {
        int[][] dxy = new int[][]{{1, 0}, {0, 1} ,{-1, -1}}; // down & horizontal & up
        int[][] matrix = new int[n][n];
        int direction = 0;
        int y = -1;
        int x = 0;
        int tryCount = 0;
        int num = 1;
        while (direction < 3) {
            if (tryCount >= 3) break;
            int dy = y + dxy[direction][0];
            int dx = x + dxy[direction][1];
            if (dy < 0 || dy >= n || dx < 0 || dx >= n || dx > dy || matrix[dy][dx] != 0) {
                tryCount++;
                direction = (++direction) % 3;
                continue;
            }
            tryCount = 0;
            y = dy;
            x = dx;
            matrix[y][x] = num++;
        }
        
        int[] answer = new int[num-1];
        int answerCount = 0;
        for (int[] arr : matrix) {
            for(int a : arr) {
                if (a == 0) continue;
                answer[answerCount++] = a;
            }
        }
        
        return answer;
    }
}