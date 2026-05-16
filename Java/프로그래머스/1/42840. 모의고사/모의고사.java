import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = new int[]{1, 2, 3, 4, 5};
        int[] student2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = new int[4];
        
        int student1Length = student1.length;
        int student2Length = student2.length;
        int student3Length = student3.length;
        
        for (int i = 0; i < answers.length; i++) {
            int currentAnswer = answers[i];
            
            if (currentAnswer == student1[i % student1Length]) {
                scores[1]++;
            }
            
            if (currentAnswer == student2[i % student2Length]) {
                scores[2]++;
            }
            
            if (currentAnswer == student3[i % student3Length]) {
                scores[3]++;
            }
        }
        
        int topScore = Math.max(scores[1], Math.max(scores[2], scores[3]));
        
        ArrayList<Integer> topRanker = new ArrayList<>(); 
        for (int i = 1; i<=3; i++) {
            if (topScore == scores[i]) topRanker.add(i);
        }
        
        int[] answer = new int[topRanker.size()];
        for (int i = 0; i < topRanker.size(); i++) {
            answer[i] = topRanker.get(i);
        }
        
        return answer;
    }
}