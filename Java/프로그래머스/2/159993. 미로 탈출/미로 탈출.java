import java.util.ArrayDeque;

class Solution {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    
    static class Point {
        int nx, ny;
        
        Point(int nx, int ny) {
            this.nx = nx;
            this.ny = ny;
        }
    }
    
    static char[][] map;
    
    static int r, c;
    
    public int solution(String[] maps) {
        c = maps.length;
        r = maps[0].length();
        
        map = new char[c][r];
        
        
        for (int y = 0; y < c; y++) {
            map[y] = maps[y].toCharArray();
        }
        
        Point start = null, passingPoint = null, end = null;
        
        for (int y = 0; y < c; y++) {
            for (int x = 0; x < r; x++) {
                if (map[y][x] == 'S') {
                    start = new Point(x, y);
                } else if (map[y][x] == 'L') {
                    passingPoint = new Point(x, y);
                } else if (map[y][x] == 'E') {
                    end = new Point(x, y);
                }
            }
        }
        
        int sTopp = bfs(start, passingPoint);
        int ppToe = bfs(passingPoint, end);
        
        if (sTopp == -1 || ppToe == -1) {
            return -1;
        }
        
        return sTopp + ppToe;
    }
    
    static int bfs(Point s, Point d) {
        int[][] distance = new int[c][r];
        ArrayDeque<Point> queue = new ArrayDeque<>();
        distance[s.ny][s.nx] = 1;
        queue.add(new Point(s.nx, s.ny));
        
        while (!queue.isEmpty()) {
            Point cureent = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int moveY = cureent.ny+dy[i];
                int moveX = cureent.nx+dx[i];
                
                if (moveY < 0 || moveY >= c || moveX < 0 || moveX >= r)
                    continue;
            
                if ((map[moveY][moveX] != 'X') && (distance[moveY][moveX] <= 0)) {
                    distance[moveY][moveX] = distance[cureent.ny][cureent.nx] + 1;
                    queue.add(new Point(moveX, moveY));
                }
                
                if (moveY == d.ny && moveX == d.nx) {
                    return distance[moveY][moveX] - 1;
                }
            }
        }
        
        return -1;
    }
    
    
}