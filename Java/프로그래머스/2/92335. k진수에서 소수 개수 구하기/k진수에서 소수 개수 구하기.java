import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        int N = n;
        while (N != 0) {
            ad.addLast(N % k);
            N /= k;
        }
        
        int answer = 0;
        long candidatePrime = 0;
        while (!ad.isEmpty()) {
            int last = ad.pollLast();
            if (last == 0) {
                if (isPrime(candidatePrime)) {
                    answer++;
                }
                candidatePrime = 0;
            } else {
                candidatePrime *= 10;
                candidatePrime += last;
            }     
        }
        
        if (isPrime(candidatePrime)) {
            answer++;
        }
        
        return answer;
    }
    
    private boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}