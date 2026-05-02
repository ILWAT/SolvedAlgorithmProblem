import java.util.ArrayList;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            ArrayList<Integer> al = new ArrayList<Integer>();
            int sum = 1;
            al.add(1);
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    sum += j;
                    al.add(j);
                }
            }
            
            if (al.size() % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }
}