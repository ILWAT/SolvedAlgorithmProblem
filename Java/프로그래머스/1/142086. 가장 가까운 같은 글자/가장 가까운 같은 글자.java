import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        HashMap<String, Integer> charMap = new HashMap<>();
        int[] answer = new int[s.length()];
        for (int i = 0; i< s.length(); i++) {
            String cs = String.valueOf(s.charAt(i));
            Integer index = charMap.getOrDefault(cs, -1);
            answer[i] = index == -1 ? index : i-index;
            charMap.put(cs, i);
        }
        return answer;
    }
}