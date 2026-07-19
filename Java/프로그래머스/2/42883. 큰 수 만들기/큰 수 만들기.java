import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int[] nCount = new int[10];
        ArrayDeque<Character> ad = new ArrayDeque<>();
        ad.addLast(number.charAt(0));
        for (int i = 1; i < number.length(); i++){
            char c = number.charAt(i);
            nCount[c - '0']++;
            while (k > 0 && !ad.isEmpty() && ad.peekLast() < c) {
                nCount[ad.pollLast() - '0']--;
                k--;
            }
            ad.addLast(c);
        }
        
        int min = 9;
        for (int i = 0; i < nCount.length; i++) {
            if (nCount[i] > 0) {
                min = i;
                break;
            }
        }
        
        while (!ad.isEmpty()) {
            char c = ad.pollFirst();
            if (k > 0 && c - '0' == min) {
                nCount[min]--;
                if (nCount[min] == 0) {
                    min++;
                }
                continue;
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
    
}