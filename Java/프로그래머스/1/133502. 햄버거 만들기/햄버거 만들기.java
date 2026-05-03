import java.util.ArrayDeque;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int[] completeBurger = new int[]{1, 2, 3, 1};
        ArrayDeque<Integer> indredientStack = new ArrayDeque<>();
        ArrayDeque<Integer> tempStack = new ArrayDeque<>();
        int currentIndex = 0;
        for (int i : ingredient) {
            indredientStack.addLast(i);
            
            if (i == 1 && indredientStack.size() >= 4) {
                boolean isComplete = false;
                for (int j = completeBurger.length - 1; j >= 0; j--) {
                    if (!indredientStack.isEmpty() && indredientStack.peekLast() == completeBurger[j]) {
                        tempStack.addLast(indredientStack.pollLast());
                        if (j == 0) {
                            isComplete = true;
                        }
                    } else {
                        break;
                    }
                }
                if (!isComplete) {
                    while (!tempStack.isEmpty()) {
                        indredientStack.addLast(tempStack.pollLast());
                    }
                } else {
                    tempStack = new ArrayDeque<>();
                    answer++;
                }
            }
        }
        
        return answer;
    }
}