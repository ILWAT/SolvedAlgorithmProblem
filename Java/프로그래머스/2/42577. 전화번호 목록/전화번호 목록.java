import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hs = new HashSet<>();
        for (String number : phone_book) {
            hs.add(number);
        }
        
        for (String number : hs) {
            StringBuilder sb = new StringBuilder();
            for (char c : number.toCharArray()) {
                sb.append(c);
                if (!sb.toString().equals(number) && hs.contains(sb.toString())) {
                    return false;
                }
            }
        }
        
        return true;
    }
}