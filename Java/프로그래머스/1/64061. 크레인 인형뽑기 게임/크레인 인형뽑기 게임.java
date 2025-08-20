import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        Stack<Integer>[] items = new Stack[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Stack<Integer>();
        }
        
        Stack<Integer> resultStack = new Stack<>();
        
        for (int y = n-1; y >= 0; y--) {
            for(int x = 0; x < n; x++) {
                int item = board[y][x];
                if (item != 0) {
                    items[x].push(item);
                }
            }
        }
        
        for (int move : moves) {
            int moveIndex = move - 1;
            if (!items[moveIndex].isEmpty()) {
                int pickedItem = items[moveIndex].pop();
                if (!resultStack.isEmpty() && pickedItem == resultStack.peek()) {
                    resultStack.pop();
                    answer += 2;
                } else {
                    resultStack.push(pickedItem);
                }
            } else {
                continue;
            }
        }
        return answer;
    }
}