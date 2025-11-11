class Solution {
    public static int N;
    public static boolean[] rcCheck; // 세로 체크
    public static boolean[] x1; // 135도 방향 대각선
    public static boolean[] x2; // 45도 방향 대각선
    
    public static int backtrace(int yPosition) {
        int ans = 0;
        if (yPosition == N) {
            ans++;
        } else {
            for (int x = 0; x<N; x++) {
                if (rcCheck[x] || x1[x+yPosition] || x2[x-yPosition+N])
                    continue;
                
                rcCheck[x] = x1[x+yPosition] = x2[x-yPosition+N] = true;
                ans += backtrace(yPosition+1);
                rcCheck[x] = x1[x+yPosition] = x2[x-yPosition+N] = false;
            }
        }
        return ans;
    }
    
    public int solution(int n) {
        int answer = 0;
        N = n;
        rcCheck = new boolean[n];
        x1 = new boolean[n*2];
        x2 = new boolean[n*2];
        answer = backtrace(0);
        return answer;
    }
}