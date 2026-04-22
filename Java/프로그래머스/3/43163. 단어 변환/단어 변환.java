import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean hasTarget = false;
        for (String w : words) {
            if (w.equals(target)) {
                hasTarget = true;
                break;
            }
        }
        if (!hasTarget) return 0;
        
        return bfs(begin, target, words);
    }
    
    private int bfs(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        ArrayDeque<String> ad = new ArrayDeque<>();
        ad.add(begin);
        
        int answer = 0;
        
        while (!ad.isEmpty()) {
            int size = ad.size();
            
            for (int i = 0; i < size; i++) {
                String currentWord = ad.pollFirst();
                
                if (currentWord.equals(target)) {
                    return answer;
                 } else {
                    for (int j = 0; j < words.length; j++) {
                        String targetWord = words[j];
                        if (!visited[j] && isDiffOnlyOne(targetWord, currentWord)) {
                            ad.addLast(targetWord);
                            visited[j] = true;
                        }
                    }
                }
            }
            answer++;
        }
        
        return 0;
    }
    
    private boolean isDiffOnlyOne(String a, String b) {
        char[] aCharArr = a.toCharArray();
        char[] bCharArr = b.toCharArray();
        int diffCount = 0;
        for (int i = 0; i < aCharArr.length; i++) {
            if (aCharArr[i] == bCharArr[i]) {
                continue;
            } else {
                diffCount++;
                if (diffCount > 1) {
                    return false;
                }
            }
        }
        
        return diffCount == 1;
    }
}