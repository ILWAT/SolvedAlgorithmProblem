class Solution {
    static int answer;
    static int[][] dun;
    static boolean[] visited;
    
    static void backtrace(int remainK, int count) {
        for (int i = 0; i < dun.length; i++) {
            if (!visited[i] && remainK >= dun[i][0]) {
                visited[i] = true;
                
                backtrace(remainK - dun[i][1], count + 1);
                answer = Math.max(answer, count + 1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        dun = dungeons;
        visited = new boolean[dun.length];
        
        backtrace(k, 0);
        return answer;
    }
}