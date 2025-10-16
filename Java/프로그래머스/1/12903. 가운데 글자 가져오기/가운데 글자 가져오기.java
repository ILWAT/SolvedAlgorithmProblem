class Solution {
    public String solution(String s) {
        int mid = s.length() / 2;
        String midcs = String.valueOf(s.charAt(mid));
        
        if (s.length() % 2 == 0) {
            midcs = String.valueOf(s.charAt(mid-1)) + midcs;
        }
        return midcs;
        
    }
}