class Solution {
    public int solution(String word) {
        int answer = 0;
        
        // 사전의 특성에 따라 단어의 n번째 문자가 다음 문자로 넘어갈 때 넘어가는 경우의 수
        int[] addedByPosition = new int[]{781, 156, 31, 6, 1};
        char[] chars = new char[]{'A', 'E', 'I', 'O', 'U'};
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = 0;
            for (; index < chars.length; index++) {
                if (chars[index] == c) break;
            }
            answer += (index * addedByPosition[i]) + 1;
        }
        return answer;
    }
}