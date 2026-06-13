import java.util.ArrayDeque;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        
        for (int i = 0; i < stones.length; i++) {
            if (!ad.isEmpty() && ad.peekFirst() <= i - k) {
                ad.pollFirst();
            }
            
            while (!ad.isEmpty() && stones[ad.peekLast()] <= stones[i]) {
                ad.pollLast();
            }
            
            ad.addLast(i);
            
            if (i >= k - 1) {
                int currentWindowMax = stones[ad.peekFirst()];
                answer = Math.min(answer, currentWindowMax);
            }
        }
        
        return answer;
    }
}