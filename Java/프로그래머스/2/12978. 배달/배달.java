import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayDeque;

class Solution {
    static class Node {
        int dest, cost;
        
        Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    
    public int solution(int N, int[][] road, int K) {
        ArrayList<Node>[] map = new ArrayList[N+1];
        for (int i = 1; i<= N; i++) {
            map[i] = new ArrayList<>();
        }
        
        for (int[] item: road) {
            map[item[0]].add(new Node(item[1], item[2]));
            map[item[1]].add(new Node(item[0], item[2]));
        }
        
        int[] costList = new int[N+1];
        Arrays.fill(costList, Integer.MAX_VALUE);
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(1, 0));
        costList[1] = 0;
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            if (costList[now.dest] < now.cost)
                continue;
            
            for (Node connected : map[now.dest]) {
                if (costList[connected.dest] > now.cost + connected.cost) {
                    costList[connected.dest] = now.cost + connected.cost;
                    queue.add(new Node(connected.dest, costList[connected.dest]));
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i < costList.length; i++) {
            if (costList[i] <= K)
                answer++;
        }

        return answer;
    }
}