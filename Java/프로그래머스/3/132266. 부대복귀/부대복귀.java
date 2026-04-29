import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        
        for (int[] road : roads) {
            int point1 = road[0];
            int point2 = road[1];
            adj[point1].add(point2);
            adj[point2].add(point1);
        }
        
        int[] fastestTime = bfs(destination, n, adj);
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = fastestTime[sources[i]];
        }
        
        return answer;
    }
    
    private static int[] bfs(int start, int n, ArrayList<Integer>[] adj) {
        int[] fastest = new int[n+1];
        for (int i = 0; i < fastest.length; i++) {
            fastest[i] = -1;
        }
        
        boolean[] visited = new boolean[n+1];
        
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        
        visited[start] = true;
        ad.addLast(start);
        fastest[start] = 0;
        
        while(!ad.isEmpty()) {
            int currentPoint = ad.pollFirst();
            for (int i = 0; i < adj[currentPoint].size(); i++) {
                int nextPoint = adj[currentPoint].get(i);
                if (!visited[nextPoint]) {
                    visited[nextPoint] = true;
                    ad.addLast(nextPoint);
                    fastest[nextPoint] = fastest[currentPoint] + 1;
                }
            }
        }
        
        return fastest;
    }
}