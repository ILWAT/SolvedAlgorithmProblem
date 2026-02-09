class Solution {
    public int solution(String[] babbling) {
        String [] canSpeak = new String[]{"aya", "ye", "woo", "ma" };
        int answer = 0;
        
        for (String word : babbling) {
            boolean possible = true;
            
            for (String speakWord : canSpeak) {
                if (word.contains(speakWord+speakWord)) {
                    possible = false;
                    break;
                }
            }
            
            if (!possible) { continue; }
            
            for (String speakWord : canSpeak) {
                word = word.replaceAll(speakWord, " ");
            }
            
            if (word.trim().equals("")) {
                answer++;
            }
            
        }
        
        return answer;
    }
}