import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> scoreMap = new HashMap<>();
        
        for (int i = 0; i<name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        }
        
        int photoCount = photo.length;
        int[] answer = new int[photoCount];
        for (int i = 0; i<photoCount; i++) {
            int score = 0;
            for (String person : photo[i]) {
                score += scoreMap.getOrDefault(person, 0);
            }
            answer[i] = score;
        }
        
        return answer;
    }
}