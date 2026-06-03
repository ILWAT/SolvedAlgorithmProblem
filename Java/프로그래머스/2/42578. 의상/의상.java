import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> categorys = new HashMap<>();
        for (String[] items : clothes) {
            String cate = items[1];
            String item = items[0];
            categorys.put(cate, categorys.getOrDefault(cate, 0) + 1);
        }
        
        int answer = 1;
        
        for (int cateCount : categorys.values()) {
            answer *= (cateCount + 1);
        }
        
        answer -= 1;
        
        return answer;
    }
}