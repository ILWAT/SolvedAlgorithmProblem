import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        for (String operation : operations) {
            String[] splited = operation.split(" ");
            String command = splited[0];
            int num = Integer.parseInt(splited[1]);
            
            if (command.equals("I")) {
                minPq.add(num);
                maxPq.add(num);
            } else {
                if (num == 1 && !maxPq.isEmpty()) {
                    int target = maxPq.poll();
                    minPq.remove(target);
                } else if (num == -1 && !minPq.isEmpty()) {
                    int target = minPq.poll();
                    maxPq.remove(target);
                }
            }
        }
        
        if (maxPq.isEmpty() || minPq.isEmpty()) {
            return new int[]{0, 0};
        }
        
        return new int[]{maxPq.peek(), minPq.peek()};
    }
}