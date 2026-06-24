import java.util.ArrayDeque;

class Solution {
    public String solution(String p) {
        return program(p);
    }
    
    private String program(String w) {
        if (w.isEmpty()) return w;
        String[] dvided = divide(w);
        String u = dvided[0];
        String v = dvided[1];
        if (validateString(u)) {
            return u + program(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(program(v));
            sb.append(')');
            for (int index = 1; index < u.length() - 1; index++) {
                sb.append(u.charAt(index) == '(' ? ')' : '(');
            }
            
            return sb.toString();
        }
    }
    
    private String[] divide(String w) {
        boolean isUCorrect = true;
        String u = "";
        String v = "";
        
        int openCount = 0;
        int closeCount = 0;
        int subStringIndex = w.length() - 1;
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (c == '(') {
                openCount++;
            } else {
                closeCount++;
            }
            if (openCount == closeCount) {
                subStringIndex = i;
                break;
            }
        }
        u = w.substring(0, subStringIndex + 1);
        if (subStringIndex + 1 < w.length()) {
            v = w.substring(subStringIndex + 1, w.length());
        }
        
        return new String[]{u, v};
    }
    
    private boolean validateString(String s) {
        ArrayDeque<Character> ad = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ad.add(c);
            } else {
                if (ad.isEmpty()) {
                    return false;
                } else {
                    ad.pollLast();
                }
            }
        }
        
        return true;
    }
}