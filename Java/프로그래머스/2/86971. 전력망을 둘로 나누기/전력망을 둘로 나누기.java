import java.util.ArrayList;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
    static int N;
    static int answer;
    
    public int solution(int n, int[][] wires) {
        N = n;
        answer = n - 1;
        visited = new boolean[n+1];
        adjList = new ArrayList[n+1];
        for (int i = 0; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }
        
        dfs(1);
        
        return answer;
    }
    
    static int dfs(int current) {
        visited[current] = true;
        int childs = 0;
        
       for (int item : adjList[current]) {
           if (!visited[item]) {
               int child = dfs(item);
               answer = Math.min(answer, Math.abs(N - (child * 2)));
               childs += child;
           }
       }
        
        return childs + 1;
    }
}