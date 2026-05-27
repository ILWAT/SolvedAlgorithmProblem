import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> hs = new HashSet<>(Arrays.asList(gems));
        int gemsCount = hs.size();
        
        HashMap<String, Integer> hm = new HashMap<>();
        int[] answer = new int[2];
        int start = 0;
        int min = Integer.MAX_VALUE;
        
        for (int end = 0; end < gems.length; end++) {
            String lastGem = gems[end];
            hm.put(lastGem, hm.getOrDefault(lastGem, 0) + 1);
        
            while (hm.size() == gemsCount) {
                if (end - start < min) {
                    min = end - start;              
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
                
                String firstGem = gems[start];
                hm.put(firstGem, hm.getOrDefault(firstGem, 0) - 1);
                if (hm.getOrDefault(firstGem, 0) <= 0) {
                    hm.remove(firstGem);
                }
                
                start++;
            }
        }
        
        return answer;
    }
}