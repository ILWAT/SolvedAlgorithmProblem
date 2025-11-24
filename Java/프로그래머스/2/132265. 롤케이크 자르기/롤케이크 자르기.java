import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> toppingsMap = new HashMap<>();
        for (int item : topping) {
            toppingsMap.put(item, toppingsMap.getOrDefault(item, 0) + 1);
        }
        
        HashSet<Integer> tasteToppings = new HashSet<>();
        for (int top : topping) {
            tasteToppings.add(top);
            toppingsMap.put(top, toppingsMap.getOrDefault(top, 1)-1);
            
            if (toppingsMap.get(top) == 0)
                toppingsMap.remove(top);
            
            if (toppingsMap.size() == tasteToppings.size())
                answer ++;
        }
        
        
        return answer;
    }
}