import java.util.HashMap;

class Solution {
    public int solution(String s) {
        HashMap<String, String> pair = new HashMap<>();
        
        pair.put("zero", "0");
        pair.put("one", "1");
        pair.put("two", "2");
        pair.put("three", "3");
        pair.put("four", "4");
        pair.put("five", "5");
        pair.put("six", "6");
        pair.put("seven", "7");
        pair.put("eight", "8");
        pair.put("nine", "9");
        
        int sCount = s.length();
        
        String tempString = "";
        String resultString = "";
        for (int i = 0; i<sCount; i++) {
            tempString += s.charAt(i);
            if (pair.containsValue(tempString)) {
                resultString += tempString;
                tempString = "";
            } else if (pair.containsKey(tempString)) {
                resultString += pair.get(tempString);
                tempString = "";
            }
        }
        
        
        return Integer.parseInt(resultString);
    }
}