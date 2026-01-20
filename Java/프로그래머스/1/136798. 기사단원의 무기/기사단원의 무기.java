class Solution {
    public int solution(int number, int limit, int power) {
        int result = 0;
        for (int i = 1; i<=number; i++) {
            int target = 0;
            for (int j = 1; j*j<=i; j++) {
                if (j * j == i) {
                    target++;
                } else if (i % j == 0) {
                    target += 2;
                }
            }
            if (target > limit) {
                target = power;
            }
            result += target;
        }
        
        return result;
    }
}