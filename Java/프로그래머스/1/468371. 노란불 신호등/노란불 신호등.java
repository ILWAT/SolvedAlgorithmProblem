import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        int[] totalCycles = new int[n];
        
        for (int i = 0; i < n; i++) {
            totalCycles[i] = signals[i][0] + signals[i][1] + signals[i][2];
        }
        
        for (int t = 1; t <= 2000000; t++) {
            int yellowCount = 0;
            
            for (int i = 0; i < n; i++) {
                int g = signals[i][0];
                int y = signals[i][1];
                int cycle = totalCycles[i];
                
                int currentTime = t % cycle;
                if (currentTime == 0) currentTime = cycle;
                
                if (currentTime > g && currentTime <= (g+y)) {
                    yellowCount++;
                } else {
                    break;
                }
            }
            
            if (yellowCount == n) return t;
        }
        return -1;   
    }
}