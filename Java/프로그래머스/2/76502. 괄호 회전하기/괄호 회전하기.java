import java.util.ArrayDeque;
import java.util.HashMap;

class Solution {
    public int solution(String s) {
        int answer = 0;
        HashMap<Character, Character> pair = new HashMap<>();
        pair.put('[', ']');
        pair.put('{', '}');
        pair.put('(', ')');
        String newS = s + s;
        int sCount = s.length();
        
        for (int i = 0; i<sCount; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>(); 
            
            for (int j = i; j < sCount+i; j++) {
                Character target = newS.charAt(j);
                
                if (pair.containsKey(target)) {
                    stack.add(target);
                } else {
                    if (!stack.isEmpty() && pair.get(stack.peekLast()) == target) {
                        stack.removeLast();
                    } else {
                        break;
                    }   
                }
            
                if (stack.isEmpty() && (j == (sCount+i-1))) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}