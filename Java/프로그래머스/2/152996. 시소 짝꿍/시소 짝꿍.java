import java.util.*;

class Solution {
    public long solution(int[] weights) {
        HashMap<Integer, Long> hm = new HashMap<>();
        
        for (int weight : weights) {
            hm.put(weight, hm.getOrDefault(weight, (long) 0) + 1);
        }
        
        long answer = 0;
        for (Map.Entry<Integer, Long> entry : hm.entrySet()) {
            int key = entry.getKey();
            long value = entry.getValue();
            
            if (value > 1) {
                answer += (value * (value - 1)) / 2;
            }
            
            if (hm.containsKey(key * 2)) {
                answer += hm.get(key * 2) * value;
            }
            
            if ((key * 3) % 2 == 0 && hm.containsKey((key * 3) / 2)) {
                answer += hm.get((key * 3) / 2) * value;
            }
            
            if ((key * 4) % 3 == 0 && hm.containsKey((key * 4) / 3))  {
                answer += hm.get((key * 4) / 3) * value;
            }
        }
        
        return answer;
    }
}