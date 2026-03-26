import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }
        
        int totalMoveCount = 0;
        
        for (int i = 0; i < m; i++) {
            int target = targets[i];
            int targetIndex = deque.indexOf(target);
            int halfIndex;
            
            if (deque.size() % 2 == 0) {
                halfIndex = deque.size() / 2 - 1;
            } else {
                halfIndex = deque.size() / 2;
            }
            
            if (targetIndex <= halfIndex) {
                for (int j = 0; j < targetIndex; j++) {
                    int temp = deque.pollFirst();
                    deque.addLast(temp);
                    totalMoveCount++;
                }
            } else {
                for (int j = 0; j < deque.size() - targetIndex; j++) {
                    int temp = deque.pollLast();
                    deque.addFirst(temp);
                    totalMoveCount++;
                }
            }
            deque.pollFirst();
        }
        
        System.out.println(totalMoveCount);
    }
}