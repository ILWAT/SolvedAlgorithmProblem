import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int length = elements.length;
        HashSet set = new HashSet<Integer>();
        int[] newElements = new int[length * 2];
        for (int i = 0; i < newElements.length; i++) {
            newElements[i] = elements[i % length];
        }
        
        for (int i = 0; i<length; i++) {
            int sum = 0;
            for (int j = 0; j<length; j++) {
                sum += newElements[i+j];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}