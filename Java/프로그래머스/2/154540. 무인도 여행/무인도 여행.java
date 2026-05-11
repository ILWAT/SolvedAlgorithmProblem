import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static String[] MAPS;
    static int[][] visited;
    static int[] xMoves = new int[]{0, 0, 1, -1};
    static int[] yMoves = new int[]{1, -1, 0, 0};
    static int yLength;
    static int xLength;
    
    public int[] solution(String[] maps) {    
        MAPS = maps;
        ArrayList<Integer> answerAL = new ArrayList<>();
        yLength = maps.length;
        xLength = maps[0].length();
        visited = new int[yLength][xLength];
        for (int y = 0; y < yLength; y++) {
            for (int x = 0; x < xLength; x++) {
                char currentChar = maps[y].charAt(x);
                if (currentChar == 'X') {
                    continue;
                } else if (visited[y][x] == 0) {
                    answerAL.add(dfs(x, y, 0));
                }
            }
        }
        
        int[] answer;
        if (answerAL.isEmpty()) {
            answer = new int[]{-1};
        } else {
            answer = answerAL.stream()
                            .mapToInt(Integer::intValue)
                            .sorted()
                            .toArray();
        }
        return answer;
    }
    
    int dfs(int startX, int startY, int sum) {
        visited[startY][startX] = 1;
        
        int nowSum = MAPS[startY].charAt(startX) - '0';
        
        for (int i = 0; i < 4; i++) {
            int dx = startX + xMoves[i];
            int dy = startY + yMoves[i];
            
            if (dx < 0 || dx >= xLength || dy < 0 || dy >= yLength) continue;
            if (MAPS[dy].charAt(dx) == 'X') continue;
            
            if (visited[dy][dx] == 0) {
                nowSum += dfs(dx, dy, sum);
            }
        }
        
        return nowSum;
    }
    
}