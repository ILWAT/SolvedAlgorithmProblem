import java.util.*;
import java.io.*;

public class Main {
    private static boolean[][] visited;
    private static int[][] matrix;
    private static int n;
    private static int m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j)-'0';
            }
        }
        
        System.out.println(bfs(0, 0));
    }
    
    private static int bfs(int x, int y) {
        ArrayDeque<int[]> ad = new ArrayDeque<>();
        int[][] dxy = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        ad.addLast(new int[]{x, y});
        while (!ad.isEmpty()) {
            int[] polled = ad.pollFirst();
            int currentX = polled[0];
            int currentY = polled[1];
            
            if (currentX == n-1 && currentY == m-1) {
                return matrix[n-1][m-1];
            }
            
            for (int[] move : dxy) {
                int movedX = currentX+move[0];
                int movedY = currentY+move[1];
                if (movedX < 0 || movedX >= n || movedY < 0 || movedY >= m) {
                    continue;
                }
                if (!visited[movedX][movedY] && (matrix[movedX][movedY] == 1)) {
                    visited[currentX][currentY] = true;
                    matrix[movedX][movedY] = matrix[currentX][currentY] + 1;
                    ad.addLast(new int[]{movedX, movedY});
                }
            }
        }
        return -1;
    }
}