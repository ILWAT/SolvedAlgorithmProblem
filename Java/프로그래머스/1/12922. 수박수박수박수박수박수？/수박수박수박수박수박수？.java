class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int setLength = n / 2;
        int setRemain = n % 2;
        for (int i = 0; i < setLength; i++) {
            sb.append("수박");
        }
        if (setRemain > 0) {
            sb.append("수");
        }
        
        return sb.toString();
    }
}