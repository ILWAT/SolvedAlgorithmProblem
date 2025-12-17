import java.util.ArrayDeque;

class Solution {
    public int solution(int[] order) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        int mainRoad = 1;
        int orderCount = order.length;
        int answer = 0;
        
        while (answer < orderCount) {
            int current = order[answer];
            
            if (ad.size() > 0 && ad.peekLast() == current) {
                ad.pollLast();
                answer++;
            } 
            else if (mainRoad <= orderCount && mainRoad == current) {
                mainRoad++;
                answer++;
            } 
            else if (current > mainRoad) {
                ad.addLast(mainRoad++);
            } 
            else {
                break;
            }
        }
        
        return answer;
    }
}