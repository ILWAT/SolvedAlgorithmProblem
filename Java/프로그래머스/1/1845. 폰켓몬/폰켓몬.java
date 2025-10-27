import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int item : nums) {
            set.add(item);
        }
        
        int nCount = nums.length;
        
        int gotYou = nCount/2;
        
        return Math.min(gotYou, set.size());
    }
}