import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int prciesCount = prices.length;
        int[] answerArray = new int[prciesCount];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for (int i = 1; i < prciesCount; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int downedPriceIndex = stack.pop();
                answerArray[downedPriceIndex] = i - downedPriceIndex;
            }
            stack.push(i);
        }
        
        
        while(!stack.isEmpty()) {
            int index = stack.pop();
            answerArray[index] = prciesCount - 1 - index;
        }
        
        return answerArray;
    }
}