class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pInt = Long.parseLong(p);
        int pLength = p.length();
        
        for (int i = 0; i < t.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < pLength; j++) {
                if (i + j >= t.length()) break;
                sb.append(t.charAt(i + j));
            }
            long subSet = Long.parseLong(sb.toString());
            if (sb.length() == pLength && subSet <= pInt) {
                answer++;
            }
        }
        return answer;
    }
}