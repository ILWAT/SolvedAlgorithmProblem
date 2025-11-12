class Solution {
    private static int maxScore;
    private static int[] answer;
    private static int[] peachResult;
    
    private static int calScore(int[] ryan) {
        int score = 0;
        for (int i = 0; i<=10; i++) {
            if (ryan[i] + peachResult[i] > 0) {
                score += (ryan[i] > peachResult[i]) ? (10-i) : -(10-i);
            }
        }
        return score;
    }
    
    private static void calResult(int[] ryan) {
        int score = calScore(ryan);
        if (maxScore < score) {
            maxScore = score;
            answer = ryan.clone();
        } else if (maxScore > 0 && maxScore == score) {
            for (int i = 10; i >= 0; i--) {
                if (answer[i] != ryan[i]) {
                    if (answer[i] < ryan[i]) {
                        answer = ryan.clone();
                    }
                    break;
                }
            }
        }
    }
    
    
    private static void backtrace(int remainArrow, int focusIndex, int[] currentResult) {
        if (remainArrow == 0) {
            calResult(currentResult);
            return;
        }
        for (int i = focusIndex; i <= 10; i++) {
            int target = Math.min(remainArrow, peachResult[i] + 1);
            currentResult[i] = target;
            backtrace(remainArrow-target, i+1, currentResult);
            currentResult[i] = 0;
        }
    }
    
    public int[] solution(int n, int[] info) {
        peachResult = info;
        maxScore = 0;
        backtrace(n, 0, new int[11]);
        return maxScore == 0 ? new int[]{-1} : answer;
    }
}