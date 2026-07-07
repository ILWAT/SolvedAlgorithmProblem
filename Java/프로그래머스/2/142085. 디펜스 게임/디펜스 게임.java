import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        for(; i < enemy.length; i++) {
            int roundCount = enemy[i];

            pq.add(roundCount);
            n -= roundCount;
            
            if (n < 0) {
                if (k > 0) {
                    n += pq.poll();
                    k--;
                } else {
                    return i;
                }
            }
        }
        return i;
    }
}