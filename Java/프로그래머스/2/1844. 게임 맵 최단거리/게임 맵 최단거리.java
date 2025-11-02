import java.util.ArrayDeque;

class Solution {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    
    static class Node {
        int r;
        int c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        
        int[][] dist = new int[N][M];
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        
        queue.addLast(new Node(0, 0));
        dist[0][0] = 1;
        
        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dx[i];
                int nc = now.c + dy[i];
                
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }
                
                if (maps[nr][nc] == 0) {
                    continue;
                }
                
                if (dist[nr][nc] == 0) {
                    queue.addLast(new Node (nr, nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }
        
        return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
    }
}