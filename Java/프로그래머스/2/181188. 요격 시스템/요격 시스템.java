import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        int msPoint = targets[0][1];
        for (int[] target : targets) {
            int s = target[0];
            int e = target[1];
            if (s >= msPoint) {
                answer++;
                msPoint = e;
            }
        }
        return answer;
    }
}