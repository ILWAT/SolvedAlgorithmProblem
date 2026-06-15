import java.util.*; 

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] new_board = new char[m][n];
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                new_board[y][x] = board[y].charAt(x);
            }
        }
        
        int answer = 0;
        boolean pang = true;
        
        while (pang) {
            boolean[][] toDelete = new boolean[m][n];
            pang = false;
            for (int y = 0; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    char now = new_board[y][x];
                    
                    if (now == '.') continue;
                    
                    if (x + 1 < n && y + 1 < m) {
                        if (now == new_board[y][x+1] && now == new_board[y+1][x] && now == new_board[y+1][x+1]) {
                            toDelete[y][x] = true;
                            toDelete[y][x+1] = true;
                            toDelete[y+1][x] = true;
                            toDelete[y+1][x+1] = true;
                            pang = true;
                        }
                    }
                    
                }
            }
                
                
            if (pang) { 
                for (int y = 0; y < m; y++) {
                    for (int x = 0; x < n; x++) {
                        if (toDelete[y][x]) {
                            new_board[y][x] = '.';
                            answer++;
                        }
                    }
                }   
                reArrangeBoard(m, n, new_board);  
            }
        }
        
        
        return answer;
    }
    
    private void reArrangeBoard(int m, int n, char[][] board) {
        int column = n;
        int row = m;
        for (int c = 0; c < column; c++) {
            for (int r = row - 1; r >= 0; r--) {
                if (board[r][c] == '.') {
                    for (int k = r - 1; k >= 0; k--) {
                        if (board[k][c] != '.') {
                            board[r][c] = board[k][c];
                            board[k][c] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}