import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int yLength = park.length;
        int xLength = park[0].length();
        
        for (int y = 0; y < yLength; y++) {
            for (int x = 0; x < xLength; x++) {
                if (park[y].charAt(x) == 'S') {
                    answer = new int[]{y, x};
                    break;
                }
            }
        }
        
        StringTokenizer st;
        for (String route : routes) {
            st = new StringTokenizer(route);
            int[] direction = notifyDirection(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            int dx = answer[1];
            int dy = answer[0];
            boolean isPossible = true;
            for (int i = 0; i < count; i++) {
                dx += direction[1];
                dy += direction[0];
                if (dx < 0 || dx >= xLength || dy < 0 || dy >= yLength) {
                    isPossible = false;
                    break;
                }
                if (park[dy].charAt(dx) == 'X') {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                answer[1] = dx;
                answer[0] = dy;
            }
        }
        
        return answer;
    }
    
    int[] notifyDirection(String d) {
        if (d.equals("E")) {
            return new int[]{0, 1};
        } else if (d.equals("W")) {
            return new int[]{0, -1};
        } else if (d.equals("N")) {
            return new int[]{-1, 0};
        } else {
            return new int[]{1, 0};
        }
    }
}