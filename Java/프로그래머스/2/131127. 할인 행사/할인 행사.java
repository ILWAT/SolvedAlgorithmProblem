import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        HashMap<String, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            targetMap.put(want[i], number[i]);
        }
        
        int answer = 0;
        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> items = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                String item = discount[j];
               if (targetMap.containsKey(item)){
                   items.put(item, items.getOrDefault(item, 0) + 1);
               }
            }
            
            if  (items.equals(targetMap)) {
                answer ++;
            }
        }
        
        return answer;
    }
}