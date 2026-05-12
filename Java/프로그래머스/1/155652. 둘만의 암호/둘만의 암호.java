import java.util.HashSet;

class Solution {
    public String solution(String s, String skip, int index) {
        HashSet<Character> skipSet = new HashSet<>();
        for (char skipC : skip.toCharArray()) {
            skipSet.add(skipC);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (char sc : s.toCharArray()) {
            int currentIndex = 0;
            char currentChar = sc;
            while (currentIndex < index) {
                currentChar++;
                if (currentChar > 'z') {
                    currentChar = 'a';
                }
                
                if (!skipSet.contains(currentChar)) {
                    currentIndex++;;
                }
            }
            sb.append(currentChar);
        }
        return sb.toString();
    }
}