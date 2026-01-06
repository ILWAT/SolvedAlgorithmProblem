import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int minY = 52;
        int minX = 52;
        int maxY = 0;
        int maxX = 0;
        
        for (int y = 0; y<wallpaper.length; y++) {
            for (int x = 0; x<wallpaper[y].length(); x++) {
                char item = wallpaper[y].charAt(x);
                if (item == '#') {
                    minY = Math.min(minY, y);
                    minX = Math.min(minX, x);
                    maxY = Math.max(maxY, y+1);
                    maxX = Math.max(maxX, x+1);
                }
            }
        }
        int[] answer = {minY, minX, maxY, maxX};
        return answer;
    }
}