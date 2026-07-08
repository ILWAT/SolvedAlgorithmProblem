import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (r1, r2) -> Integer.compare(r1[1], r2[1]));
        
        int answer = 0;
        int point = Integer.MIN_VALUE;
        for (int i = 0; i < routes.length; i++) {
            if (routes[i][0] > point) {
                answer++;
                point = routes[i][1];
            }
        }
        
        return answer;
    }
}