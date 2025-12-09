import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> category = new HashMap<>();
        for (int tan : tangerine) {
            category.put(tan, category.getOrDefault(tan, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(category.values());
        list.sort(Collections.reverseOrder());
        
        int answer = 0;
        int index = 0;
        while (k > 0) {
            ++answer;
            if (list.get(index) >= k) break;
            k -= list.get(index++);
        }
        
        return answer;
    }
}