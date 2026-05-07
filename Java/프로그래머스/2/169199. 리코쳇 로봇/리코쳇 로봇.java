import java.util.ArrayDeque;

class Solution {
    public int solution(String[] board) {
        int startX = 0, startY = 0;
        int endX = 0, endY = 0;
        int[][] dxyArr = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        ArrayDeque<int[]> ad = new ArrayDeque<>();

        int maxX = board[0].length();
        int maxY = board.length;
        
        int[][] boardNote = new int[maxY][maxX];
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                char currentItem = board[i].charAt(j);
                if (currentItem == 'D') {
                    boardNote[i][j] = -1;
                } else if (currentItem == 'R') {
                    startX = j;
                    startY = i;
                    boardNote[i][j] = 0;
                } else {
                    if (currentItem == 'G') {
                        endX = j;
                        endY = i;
                    }
                    boardNote[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        ad.add(new int[]{startX, startY});

        while (!ad.isEmpty()) {
            int[] offset = ad.pollFirst();
            for (int[] dxy : dxyArr) {
                int nowX = offset[0];
                int nowY = offset[1];
                int count = boardNote[nowY][nowX] + 1;
                while (nowX >= 0 && nowX <= (maxX - 1) && nowY >= 0 && nowY <= (maxY - 1)) {
                    int nextX = nowX + dxy[0];
                    int nextY = nowY + dxy[1];

                    if (nextX < 0 || nextX >= maxX || nextY < 0 || nextY >= maxY) {
                        if (boardNote[nowY][nowX] > count) {
                            boardNote[nowY][nowX] = count;
                            ad.add(new int[]{nowX, nowY});
                        }
                        break;
                    } else if (boardNote[nextY][nextX] == -1) {
                        if (boardNote[nowY][nowX] > count) {
                            boardNote[nowY][nowX] = count;
                            ad.add(new int[]{nowX, nowY});
                        }
                        break;
                    }
                    nowX = nextX;
                    nowY = nextY;
                }
            }
        }
        
        return boardNote[endY][endX] == Integer.MAX_VALUE ? -1 : boardNote[endY][endX];
    }
}