import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int item : score) {
            countMap.put(item, (countMap.getOrDefault(item, 0) + 1));
        }
        
        int answer = 0;
        int inBoxRemain = m;
        int inBoxMin = k+1;
        for (int i = k; i>=1; i--) {
            while(countMap.getOrDefault(i, 0) > 0) {
                countMap.put(i,countMap.getOrDefault(i, 0)-1);
                inBoxMin = Math.min(inBoxMin, i);
                inBoxRemain--;
                if (inBoxRemain == 0) {
                    answer += (inBoxMin * m);
                    inBoxRemain = m;
                    inBoxMin = k+1;
                }
            }
        }
        
        return answer;
    }
}