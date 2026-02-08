class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String word : babbling) {
            String replaced = word.replaceAll("aya|ye|woo|ma", " ");
            
            if (replaced.replaceAll(" ", "").equals("")) {
                answer ++;
            }
        }
        return answer;
    }
}