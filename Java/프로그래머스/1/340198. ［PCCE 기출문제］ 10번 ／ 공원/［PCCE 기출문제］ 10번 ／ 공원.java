import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        
        for (int matIndex = mats.length - 1; matIndex >= 0; matIndex--) {
            int mat = mats[matIndex];
            for (int y = 0; y < park.length; y++) {
                for (int x = 0; x < park[y].length; x++) {
                    if (isAvailable(park, x, y, mat)) {
                        return mat;
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean isAvailable(String[][] park, int x, int y, int length) {
        if (y + length > park.length || x + length > park[0].length) {
            return false;
        }
        
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (!park[y + i][x + j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}