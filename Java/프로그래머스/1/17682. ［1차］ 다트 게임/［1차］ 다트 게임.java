import java.util.ArrayList;

class Solution {
    public int solution(String dartResult) {
        int length = dartResult.length();
        ArrayList<Integer> scores = new ArrayList<>();
        char[] dartArray = dartResult.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = dartArray[i];
            
            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else if (c == 'S' || c == 'D' || c == 'T') {
                int score = Integer.parseInt(sb.toString());
                
                if (c == 'S') {
                    scores.add(score);
                } else if (c == 'D') {
                    scores.add(score * score);
                } else if (c == 'T') {
                    scores.add(score * score * score);
                }
                
                sb.setLength(0);
            } else if (c == '*') {
                int sLength = scores.size();
                if (sLength >= 1) {
                    scores.set(sLength - 1, scores.get(sLength - 1) * 2);
                }
                if (sLength >= 2) {
                    scores.set(sLength - 2, scores.get(sLength - 2) * 2);
                }
            } else if (c == '#') {
                int sLength = scores.size();
                if (sLength >= 1) {
                    scores.set(sLength - 1, scores.get(sLength - 1) * -1);
                }
            }
        }
        
        int answer = 0;
        for (int score : scores) {
            answer += score;
        }
        return answer;
    }
}