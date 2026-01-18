import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    private static HashMap<String, Integer> termsLimit = new HashMap<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        splitTermsLimit(terms);
        
        int todayTotalDays = dateToDays(today);
        
        ArrayList<Integer> expiredList = new ArrayList<>();
        
        for (int i = 0; i < privacies.length; i++) {
            String[] splitPrivacy = privacies[i].split(" ");
            String dateStr = splitPrivacy[0];
            String termType = splitPrivacy[1];
            
            int collectedDays = dateToDays(dateStr);
            int limitMonth = termsLimit.get(termType);
            
            if (collectedDays + (limitMonth * 28) <= todayTotalDays) {
                expiredList.add(i + 1);
            }
        }
        
        return expiredList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private void splitTermsLimit(String[] terms) {
        for (String term: terms) {
            String[] termSplited = term.split(" ");
            termsLimit.put(termSplited[0], Integer.parseInt(termSplited[1]));
        }
    }
    
    private int dateToDays(String date) {
        String[] dateSplited = date.split("\\.");
        int year = Integer.parseInt(dateSplited[0]);
        int month = Integer.parseInt(dateSplited[1]);
        int day = Integer.parseInt(dateSplited[2]);
        return (year * 12 * 28) + (month *28) + day;
    }
}