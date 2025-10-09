import java.util.HashMap;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int enrollLength = enroll.length;
        //추천인 link 구조 만들기
        HashMap<String, String> parentMap = new HashMap<>();
        for (int i = 0; i<enrollLength; i++) {
            parentMap.put(enroll[i], referral[i]);
        }
        
        //수익금 종합
        HashMap<String, Integer> sellingResult = new HashMap<>();
        for (int i = 0; i<seller.length; i++) {
            String person = seller[i];
            Integer amountMoney = amount[i] * 100;
            
            while (amountMoney > 0 && !person.equals("-")) {
                
                sellingResult.put(person, sellingResult.getOrDefault(person, 0) + amountMoney - (amountMoney/10));
                person = parentMap.getOrDefault(person, "-");
                amountMoney = amountMoney / 10;
                }
        }
        
        int[] answer = new int[enrollLength];
        for (int i = 0; i<enrollLength; i++) {
            String person = enroll[i];
            answer[i] = sellingResult.getOrDefault(person, 0);
        }
        
        return answer;
    }
}