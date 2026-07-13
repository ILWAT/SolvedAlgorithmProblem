import java.util.HashSet;

class Solution {
    private HashSet<Integer> hs = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        selectCard("", numbers);
        
        for (int num : hs) {
            if (validation(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    private void selectCard(String maked, String remain) {
        if (!maked.equals("")) {
            hs.add(Integer.parseInt(maked));
        }
        
        for (int i = 0; i < remain.length(); i++) {
            selectCard(maked + remain.charAt(i), remain.substring(0, i) + remain.substring(i+1, remain.length()));
        }
    }
    
    private boolean validation(int num) {
        if (num < 2) return false;
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
            
            if (count > 2) {
                return false;
            }
        }
        
        return true;
    }
}