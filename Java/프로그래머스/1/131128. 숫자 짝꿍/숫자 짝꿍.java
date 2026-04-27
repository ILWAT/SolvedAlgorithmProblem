import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < X.length(); i++) {
            char current = X.charAt(i);
            hm.put(current, hm.getOrDefault(current, 0) + 1);
        }
        
        int[] numCount = new int[10];
        for (int i = 0; i < Y.length(); i++) {
            char current = Y.charAt(i);
            int count = hm.getOrDefault(current, 0);
            if (count > 0) {
                hm.put(current, count - 1);
                numCount[current - '0']++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = numCount.length - 1; i >= 0; i--) {
            if (i == 0 && numCount[i] > 0 && sb.length() == 0) {
                sb.append(i);
                break;
            }
            
            while (numCount[i] > 0) {
                sb.append(i);
                numCount[i]--;
            }
        }
        
        return sb.length() == 0 ? "-1" : sb.toString();
    }
}