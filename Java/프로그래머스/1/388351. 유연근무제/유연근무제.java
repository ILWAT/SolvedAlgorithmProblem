class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int person = 0; person < schedules.length; person++) {
            int targetTime = schedules[person];
            int maximumTime = validateTime(targetTime + 10);
            
            int[] realTime = timelogs[person];
            boolean isEligible = true;
            for (int record = 0; record < realTime.length; record++) {
                int day = startday + record;
                if (day > 7) {
                    day %= 7;
                }
                
                if (day == 6 || day == 7) {
                    continue;
                }
                else {
                    if (realTime[record] > maximumTime) {
                        isEligible = false;
                        break;
                    }
                }
            }
            if (isEligible) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private int validateTime(int time) {
        int hour = (int)(time / 100);
        int min = (int)(time % 100);
        if (min >= 60) {
            time = time - 60 + 100;
        }
        return time;
    }
}