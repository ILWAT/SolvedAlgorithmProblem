class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answerSB = new StringBuilder();
        long total = t * m;
        int indexP = p - 1;
        int num = 0;
        while (sb.length() < total) {
            sb.append(change(num++, n));
        }
        
        String s = sb.toString();
        for (int i = 0; i < t; i++) {
            answerSB.append(s.charAt(indexP));
            indexP += m;
        }
        
        return answerSB.toString();
    }
    
    private String change(int num, int n) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int remainder = num % n;
            if (remainder >= 10) {
                sb.append((char) ('A' + (remainder - 10)));
            } else {
                sb.append(remainder);
            }
            num /= n;
        }
    
        return sb.reverse().toString();
    }
}