import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int[][] keypad = {
            {3, 1},
            {0, 0},
            {0, 1},
            {0, 2},
            {1, 0},
            {1, 1},
            {1, 2},
            {2, 0},
            {2, 1},
            {2, 2},
        };
        
        int[] leftPos = {3, 0};
        int[] rightPos = {3, 2};
        
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                leftPos = keypad[num];
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                rightPos = keypad[num];
            } else {
                int[] keypadPos = keypad[num]; 
                int lDist = getDistance(leftPos, keypadPos);
                int rDist = getDistance(rightPos, keypadPos);
                
                if (lDist < rDist) {
                    sb.append("L");
                    leftPos = keypad[num];
                } else if (lDist > rDist) {
                    sb.append("R");
                    rightPos = keypad[num];
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        leftPos = keypad[num];
                    } else {
                        sb.append("R");
                        rightPos = keypad[num];
                    }
                }
            }
        }
        return sb.toString();
    }
    
    static private int getDistance(int[] position, int[] target) {
        return Math.abs(position[0] - target[0]) + Math.abs(position[1] - target[1]);
    }
}