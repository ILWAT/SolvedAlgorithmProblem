class Solution {
    public int solution(int num) {
        if (num == 1) return 0;
        long NUM = num;
        int answer = -1;
        for (int i = 0; i < 500; i++) {
            if (NUM == 1) {
                answer = i;
                break;
            }
            
            NUM = (NUM % 2 == 0) ? (NUM / 2) : (NUM * 3) + 1;
        }
        
        return answer;
    }
}