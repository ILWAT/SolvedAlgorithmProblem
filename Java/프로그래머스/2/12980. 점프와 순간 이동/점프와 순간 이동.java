import java.util.*;

public class Solution {
    public int solution(int n) {
        // 최소: 1
        int ans = 1;
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }
            if (n==1)
                break;
        }

        return ans;
    }
}