import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        HashSet<String> openWordMap = new HashSet<>();
        HashSet<String> prevSpoilerWord = new HashSet<>();
        
        ArrayList<String>[] spoilerWords = new ArrayList[spoiler_ranges.length];
        for (int i = 0; i < spoilerWords.length; i++) {
            spoilerWords[i] = new ArrayList<>();
        }
        
        
        StringTokenizer st = new StringTokenizer(message);
        int startPoint = 0;
        while (st.hasMoreTokens()) {
            String currentWord = st.nextToken();
            startPoint = message.indexOf(currentWord, startPoint);
            int length = currentWord.length();
            int endPoint = startPoint+length-1;
            
            boolean isSpoiler = false;
            
            for (int i = 0; i < spoiler_ranges.length; i++) {
                int sStart = spoiler_ranges[i][0];
                int sEnd = spoiler_ranges[i][1];
                
                if (startPoint <= sEnd && endPoint >= sStart) {
                    spoilerWords[i].add(currentWord);
                    isSpoiler = true;
                }
            }
            
            if (!isSpoiler) {
                openWordMap.add(currentWord);
            }
            startPoint += (length+1);
        }

        for (int i = 0; i < spoilerWords.length; i++) {
            ArrayList<String> currentWords = spoilerWords[i];
            for (int j = 0; j < currentWords.size(); j++) {
                String currentWord = currentWords.get(j);
                if (!openWordMap.contains(currentWord) && !prevSpoilerWord.contains(currentWord)) {
                    
                    prevSpoilerWord.add(currentWord);
                }
            }
        }
                                 
        return prevSpoilerWord.size();
    }
}