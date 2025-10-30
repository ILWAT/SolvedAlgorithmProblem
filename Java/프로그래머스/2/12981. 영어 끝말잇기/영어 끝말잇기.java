import java.util.HashSet;
import java.util.HashMap;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        HashMap<Integer, Integer> turnCount = new HashMap<>();
        
        char lastChar = words[0].charAt(0);
        int[] result = new int[2];
        for (int i = 0; i<words.length; i++) {
            int person = (i % n) + 1;
            int count = turnCount.getOrDefault(person, 0) + 1;
            turnCount.put(person, count);
            String word = words[i];
            if (lastChar != word.charAt(0) || wordSet.contains(word)) {
                result[0] = person;
                result[1] = count;
                return result;
            }
            
            lastChar = word.charAt(word.length()-1);
            wordSet.add(word);
            
        }

        return result;
    }
}