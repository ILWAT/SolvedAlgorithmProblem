import java.util.ArrayList;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        long totalSum = 0;
        int n = queue1.length;
        int[] circularQueue = new int[n * 2];
        
        for (int i = 0; i < n; i++) {
            circularQueue[i] = queue1[i];
            circularQueue[i + n] = queue2[i];
            sum1 += queue1[i];
            sum2 += queue2[i];
            totalSum += (queue1[i] + queue2[i]);
        }

        
        if (totalSum % 2 > 0) return -1;
        long target = totalSum / 2;

        int point1 = 0;
        int point2 = n;
        int answer = 0;
        int max = n * 4;
        while (answer <= max) {
            if (sum1 == target && sum2 == target) return answer;

            if (target < sum1) {
                int startNum = circularQueue[point1];
                sum1 -= startNum;
                sum2 += startNum;
                point1= (point1 + 1) % (n * 2);
            } else {
                int endNum = circularQueue[point2];
                sum1 += endNum;
                sum2 -= endNum;
                point2 = (point2 + 1) % (n * 2);
            }
            answer ++;
        }

        
        return -1;
    }
}