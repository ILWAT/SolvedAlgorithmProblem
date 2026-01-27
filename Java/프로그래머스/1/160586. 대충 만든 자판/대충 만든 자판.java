import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> keyIndex = new HashMap<>();
        
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                Character keyItem = key.charAt(i);
                if (keyIndex.getOrDefault(keyItem, 101) > (i+1)) {
                    keyIndex.put(keyItem, i+1);
                }
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int result = 0;
            for (int j = 0; j < target.length(); j++) {
                Character keyItem = target.charAt(j);
                int index = keyIndex.getOrDefault(keyItem, -1);
                if (index == -1) {
                    result = -1;
                    break;
                }
                result += index;
            }
            answer[i] = result;
        }
        return answer;
    }
}