import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        boolean prevIsSpace = true;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                prevIsSpace = true;
                sb.append(c);
                continue;
            }
            
            if (prevIsSpace) {
                prevIsSpace = false;
                if (c >= 'a' && c <= 'z') {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(c);
                }
            } else {
                if (c >= 'A' && c <= 'Z') {
                    sb.append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
        }
        
        return sb.toString();
    }
}