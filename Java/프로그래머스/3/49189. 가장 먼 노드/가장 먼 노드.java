import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<LinkedList<Integer>> al = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            al.add(new LinkedList<>());
        }
        
        for (int[] vertex : edge) {
            al.get(vertex[0]).add(vertex[1]);
            al.get(vertex[1]).add(vertex[0]);
        }
        
        int[] visited = new int[n + 1];
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.add(1);
        visited[1] = 1;
        while(!ad.isEmpty()) {
            answer = ad.size();
            for (int i = 0; i < answer; i++) {
                int nowNode = ad.pollFirst();
                LinkedList<Integer> connected = al.get(nowNode);
                for (int nextNode : connected) {
                    if (visited[nextNode] == 0) {
                        visited[nextNode] = 1;
                        ad.addLast(nextNode);
                    }
                }
            }
            
        }
        
        
        return answer;
    }
}