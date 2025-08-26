import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> cards1Queue = new ArrayDeque<String>(Arrays.asList(cards1));
        ArrayDeque<String> cards2Queue = new ArrayDeque<String>(Arrays.asList(cards2));
        ArrayDeque<String> goalQueue = new ArrayDeque<String>(Arrays.asList(goal));
        
        while (!goalQueue.isEmpty()) {
            if (!cards1Queue.isEmpty() && cards1Queue.peekFirst().equals(goalQueue.peekFirst())) {
                cards1Queue.pollFirst();
                goalQueue.pollFirst();
            } else if (!cards2Queue.isEmpty() && cards2Queue.peekFirst().equals(goalQueue.peekFirst())) {
                cards2Queue.pollFirst();
                goalQueue.pollFirst();
            } else {
                break;
            }
        }
        
        return goalQueue.isEmpty() ? "Yes" : "No";
    }
}