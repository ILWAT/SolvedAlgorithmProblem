class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int aGCD = arrayA[0];
        for (int aElement : arrayA) {
            aGCD = getGCD(aElement, aGCD);
        }
        
        int bGCD = arrayB[0];
        for (int bElement : arrayB) {
            bGCD = getGCD(bElement, bGCD);
        }
        
        int answer = 0;
        if (isNotDivide(bGCD, arrayA)) {
            answer = Math.max(bGCD, answer);
        }
        
        if (isNotDivide(aGCD, arrayB)) {
            answer = Math.max(aGCD, answer);
        }
        
        return answer;
    }
    
    private int getGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        
        return a;
    }
    
    private boolean isNotDivide(int a, int[] array) {
        for (int element : array) {
            if (element % a == 0) {
                return false;
            }
        }
        return true;
    }
}