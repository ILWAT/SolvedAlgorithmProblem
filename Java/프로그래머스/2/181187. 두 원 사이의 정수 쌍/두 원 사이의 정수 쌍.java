class Solution {
    private int R1;
    private int R2;
    
    public long solution(int r1, int r2) {
        R1 = r1;
        R2 = r2;
        long answer = 0;
        for (int x = 0; x <= r2; x++) {
            for (int y = 0; y <= r2; y++) {
                if (isInRange(x, y)) {
                    answer++;
                }
            }
        }
        
        
        return (answer * 4) - 8;
    }
    
    private boolean isInRange (int x, int y) {
        if (y == 0) {
            return x <= R2 && x >= R1;
        } else {
            double distance = Math.sqrt((x*x) + (y*y));
            return distance <= R2 && distance >= R1;
        }
    }
}