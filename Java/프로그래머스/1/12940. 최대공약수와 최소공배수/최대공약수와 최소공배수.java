class Solution {
    public int[] solution(int n, int m) {
        int gcd = euclid(n, m);
        int i = ((n * m) % gcd == 0) ? ((n * m) / gcd) : n * m;
        int[] answer = new int[]{gcd, i};
        return answer;
    }
    
    private int euclid(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}