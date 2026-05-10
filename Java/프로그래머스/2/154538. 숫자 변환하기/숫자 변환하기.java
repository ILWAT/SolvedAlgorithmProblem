import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        
        int[] visited = new int[y+1];
        visited[x] = -1;
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        
        ad.add(y);
        while (!ad.isEmpty()) {
            int current = ad.pollFirst();
            
            int function1 = current - n;
            if (function1 >= x && visited[function1] <= 0) {
                visited[function1] = visited[current] + 1;
                ad.addLast(function1);
            }
            
            if (current % 2 == 0) {
                int function2 = current / 2;
                if (function2 >= x && visited[function2] <= 0) {
                    visited[function2] = visited[current] + 1;
                    ad.addLast(function2);
                }
            }
            
            
            if (current % 3 == 0) {
                int function3 = current / 3;
            
                if (function3 >= x && visited[function3] <= 0) {
                    visited[function3] = visited[current] + 1;
                    ad.addLast(function3);
                }
            }            
        
            if (visited[x] > -1) {
                break;
            }
        }
        
        return visited[x];
    }
}