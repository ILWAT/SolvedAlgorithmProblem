class Solution {
    public static int boardLength = 3;
    public static String[] Board;
    
    public int solution(String[] board) {
        Board = board;
        int oCount = 0;
        int xCount = 0;
        
        for (int y = 0; y<boardLength; y++) {
            String row = board[y];
            for (int x = 0; x<boardLength; x++) {
                if (row.charAt(x) == 'O') {
                    oCount++;
                    continue;
                }
                else if (row.charAt(x) == 'X') {
                    xCount++;
                    continue;
                }
            }
        }
        
        int diff = oCount - xCount;
        if (diff < 0 || diff > 1) return 0;
        
        boolean oWin = playerWin('O');
        boolean xWin = playerWin('X');
        
        if (oWin && xWin) return 0;
        
        if (oWin) {
            return (diff == 1) ? 1 : 0;
        } 
        if (xWin) {
            return (diff == 0) ? 1 : 0;
        }
        
        return 1;
    }
    
    public static boolean playerWin(char c) {
        for (int i = 0; i < 3; i++) {
            if (Board[i].charAt(0) == c && Board[i].charAt(1) == c && Board[i].charAt(2) == c) return true;
            if (Board[0].charAt(i) == c && Board[1].charAt(i) == c && Board[2].charAt(i) == c) return true;
        }
        if (Board[0].charAt(0) == c && Board[1].charAt(1) == c && Board[2].charAt(2) == c) return true;
        if (Board[0].charAt(2) == c && Board[1].charAt(1) == c && Board[2].charAt(0) == c) return true;
        return false;
    }
}