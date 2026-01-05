import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] convertedTime = new int[book_time.length][2];
        
        for (int i = 0; i<book_time.length; i++) {
            int enter = timeToMin(book_time[i][0]);
            int out = timeToMin(book_time[i][1]) + 10;
            convertedTime[i][0] = enter;
            convertedTime[i][1] = out;
        }
        
        Arrays.sort(convertedTime, (x, y) -> x[0]-y[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int answer = 0;
        for (int[] customer : convertedTime) {
            int enter = customer[0];
            int out = customer[1];
            
            if (!pq.isEmpty() && pq.peek() <= enter) {
                pq.poll();
            }
            pq.add(out);
        }
        
        return pq.size();
    }
    
    public static int timeToMin(String time) {
        String[] timeArr = time.split(":");
        int minTime = (Integer.parseInt(timeArr[0]) * 60) + Integer.parseInt(timeArr[1]);
        return minTime;
    }
}