class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        String color = board[h][w];
        int[] dh = new int[]{0, 1, -1, 0};
        int[] dw = new int[]{1, 0, 0, -1};
        int count = 0;
        
        for (int i = 0; i < dh.length; i++) {
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            if (h_check < 0 || h_check >= n || w_check < 0 || w_check >= n) continue;
            if (color.equals(board[h_check][w_check])) {
                count++;
            }
        }
        
        return count;
    }
}