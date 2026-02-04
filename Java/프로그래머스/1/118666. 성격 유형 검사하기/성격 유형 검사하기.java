import java.util.*;

class Solution {
    private static HashMap<Character, Integer> RT = new HashMap<>();
    private static HashMap<Character, Integer> CF = new HashMap<>();
    private static HashMap<Character, Integer> JM = new HashMap<>();
    private static HashMap<Character, Integer> AN = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        RT.put('R', 0);
        RT.put('T', 0);
        CF.put('C', 0);
        CF.put('F', 0);
        JM.put('J', 0);
        JM.put('M', 0);
        AN.put('A', 0);
        AN.put('N', 0);
        
        for (int i = 0; i<survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            int choice = choices[i];
            
            if (choice == 4) {
                continue;
            } else {
                char getScoreItem = (choice < 4) ? first : second;
                calScore(survey[i], getScoreItem, Math.abs(choice-4));
            }
        }
        
        
        
        return calResult();
    }
    
    private static void calScore(String surveyItem, char upItem, int score) {
        if (surveyItem.equals("RT") || surveyItem.equals("TR")) {
            RT.put(upItem, RT.getOrDefault(upItem, 0) + score);
        } else if (surveyItem.equals("FC") || surveyItem.equals("CF")) {
            CF.put(upItem, CF.getOrDefault(upItem, 0) + score);
        } else if (surveyItem.equals("MJ") || surveyItem.equals("JM")) {
            JM.put(upItem, JM.getOrDefault(upItem, 0) + score);
        } else {
            AN.put(upItem, AN.getOrDefault(upItem, 0) + score);
        }
    }
    
    private static String calResult() {
        StringBuilder sb = new StringBuilder();
        List<HashMap<Character, Integer>> list = List.of(RT, CF, JM, AN);
        
        for (HashMap<Character, Integer> hm : list) {
            char maxKey = ' ';
            char minKey = Character.MAX_VALUE;
            int maxValue = -1;
            for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
                char currentKey = entry.getKey();
                int currentValue = entry.getValue();
                
                if (maxValue < currentValue) {
                    maxKey = currentKey;
                    maxValue = currentValue;
                }
                
                if (currentKey < minKey) minKey = currentKey;
            }
            
            if (maxValue == 0) {
                sb.append(String.valueOf(minKey));
            } else {
                sb.append(String.valueOf(maxKey));
            }
        }
        
        return sb.toString();
    }
}