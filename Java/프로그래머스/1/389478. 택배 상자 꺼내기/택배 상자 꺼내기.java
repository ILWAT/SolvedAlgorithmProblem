class Solution {
    public int solution(int n, int w, int num) {
        int h = (n / w) + 1;
        int[][] map = new int[h][w];
        
        int number = 1;
        int targetYIndex = 0;
        int targetXIndex = 0;
        
        for (int i = 0; i < h; i++) {
            if (i % 2 == 0) {
                  for (int j = 0; j < w; j++) {
                      if (number > n) break;
                      map[i][j] = number;
                      if (num == number) {
                          targetYIndex = i;
                          targetXIndex = j;
                      }
                      number++;
                  }  
            } else {
                for (int j = w-1; j >= 0; j--) {
                    if (number > n) break;
                    map[i][j] = number;
                      if (num == number) {
                          targetYIndex = i;
                          targetXIndex = j;
                      }
                      number++;
                }
            }
        }
        
        int answer = 0;
        for (int i = targetYIndex; i < h; i++) {
            if (map[i][targetXIndex] != 0) {
                answer++;
            }
        }
        
        
        return answer;
    }
}