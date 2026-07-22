class Solution {
    public boolean solution(int x) {
        if ((x % harshad(x)) == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    private int harshad(int input) {
        int result = 0;
        while (input != 0) {
            result += (input % 10);
            input /= 10;
        }
        return result;
    }
}