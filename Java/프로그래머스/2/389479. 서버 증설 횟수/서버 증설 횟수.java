import java.util.*;

public class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int serverInNow = 0;
        ArrayDeque<int[]> timeLimit = new ArrayDeque<>();
        
        for (int now = 0; now < players.length; now++) {
            while (!timeLimit.isEmpty() && now == timeLimit.peekFirst()[0]) {
                int[] data = timeLimit.pollFirst();
                serverInNow -= data[1];
            }
            
            int currentUesr = players[now];
            int n = currentUesr / m;
            
            if (serverInNow < n) {
                int more = n - serverInNow;
                timeLimit.addLast(new int[]{now + k, more}); 
                serverInNow += more;
                answer += more;
            }
        }
        
        return answer;
    }
}