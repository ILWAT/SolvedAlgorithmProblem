class Solution {
    public int[] solution(String s) {
        int removeCount = 0;
        int changeCount = 0;
        
        while(!s.equals("1")) {
            changeCount++;
            
            int zeroCount = s.replace("1", "").length();
            removeCount += zeroCount;
            
            s = Integer.toBinaryString(s.length()-zeroCount);
        }
        
        return new int[]{changeCount, removeCount};
    }
}