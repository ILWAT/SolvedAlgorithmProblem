class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int rowMax = ((int) Math.pow(2, n)) - 1;
        int msb = (int) Math.pow(2, n - 1);
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int c = (arr1[i] | arr2[i]) & rowMax;
            for (int j = 0; j < n; j++) {
                if ((c & msb) == msb) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
                c = (c * 2);
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}