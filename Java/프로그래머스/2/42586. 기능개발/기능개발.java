import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int progressCount = progresses.length;
        int[] completedDays = new int[progressCount];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < progressCount; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int day = 0;
            while (progress < 100) {
                progress += speed;
                day++;
            }
            completedDays[i] = day;
        }
        
        int maxDay = completedDays[0];
        int feature = 0;
        for (int i = 0; i < completedDays.length; i++) {
            if (maxDay >= completedDays[i]) {
                feature++;
            } else {
                queue.addLast(feature);
                maxDay = completedDays[i];
                feature = 1;
            }
        }
        queue.addLast(feature);
        
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}