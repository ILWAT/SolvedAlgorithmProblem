class Solution {
    static boolean[] visited;
    static int[][] com;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        com = computers;
        visited = new boolean[n];
        
        for (int item = 0; item < n; item++) {
            if (!visited[item]) {
                dfs(item);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dfs(int current) {
        visited[current] = true;
        
        int[] connecting = com[current];
        for (int i = 0; i < connecting.length; i++) {
            if (i == current)
                continue;
            
            if (connecting[i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}