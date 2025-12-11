class Solution {
    public int[] solution(int[] sequence, int k) {
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        int R = 0;
        int L = 0;
        int sum = 0;
        for (; L<sequence.length; L++) {
            while (R<sequence.length && sum < k) {
                sum += sequence[R++];
            }
            
            if (sum == k && min > R-L) {
                    answer[0] = L;
                    answer[1] = R-1;
                    min = R-L;
            }
            
            sum -= sequence[L];
        }
        
        
        return answer;
    }
}