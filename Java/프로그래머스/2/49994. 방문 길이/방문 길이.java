

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x = 5, y = 5;
        boolean[][] hVisited = new boolean[11][10];
        boolean[][] vVisited = new boolean[10][11];
        
        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            int[] dxy = calDxy(c);
            int nx = x + dxy[0];
            int ny = y + dxy[1];
            
            // 범위를 벗어나면 무시
            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
            
            if (c == 'L' || c == 'R') {
                int minX = Math.min(x, nx);
                if (!hVisited[y][minX]) {
                    hVisited[y][minX] = true;
                    answer++;
                }
            } else {
                int minY = Math.min(y, ny);
                if (!vVisited[minY][x]) {
                    vVisited[minY][x] = true;
                    answer++;
                }
            }
            
            x = nx;
            y = ny;
        }
        
        return answer;
    }
    
    private static int[] calDxy(char command) {
        if (command == 'U') return new int[]{0, 1};
        if (command == 'D') return new int[]{0, -1};
        if (command == 'L') return new int[]{-1, 0};
        if (command == 'R') return new int[]{1, 0};
        return new int[]{0, 0};
    }
}