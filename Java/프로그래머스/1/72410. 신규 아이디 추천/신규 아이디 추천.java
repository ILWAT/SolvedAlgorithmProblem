class Solution {
    public String solution(String new_id) {
        String answer = new_id;
        // step 1
        answer = answer.toLowerCase();
            
        // step 2
        StringBuilder sb = new StringBuilder();
        for (char c : answer.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || c == '-' || c == '_' || c == '.') {
                sb.append(String.valueOf(c));
            }
        }
        answer = sb.toString();
        
        // step 3
        while (answer.contains("..")) {
            answer = answer.replace("..", ".");
        }
        
        //step 4
        if (answer.length() > 0 && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }
        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }
        
        
        //step 5
        if (answer.isEmpty()) {
            answer = "a";
        }
        
        // step 6
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, 14);
            }
        }
        
        if (answer.length() <= 2) {
            sb = new StringBuilder(answer);
            char lastChar = answer.charAt(answer.length()-1);
            while(sb.length() < 3) {
                sb.append(String.valueOf(lastChar));
            } 
            answer = sb.toString();
        }
        
        
        return answer;
    }
}