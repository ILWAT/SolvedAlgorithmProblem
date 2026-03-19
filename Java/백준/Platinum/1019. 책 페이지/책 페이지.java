import java.util.*;

public class Main {
    static long[] ans = new long[10];
    static long point = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long start = 1;
        long end = sc.nextLong();

        while (start <= end) {
            while (start % 10 != 0 && start <= end) {
                count(start);
                start++;
            }

            if (start > end) break;

            while (end % 10 != 9 && start <= end) {
                count(end);
                end--;
            }

            long diff = (end / 10 - start / 10 + 1);
            for (int i = 0; i < 10; i++) {
                ans[i] += diff * point;
            }

            start /= 10;
            end /= 10;
            point *= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static void count(long num) {
        while (num > 0) {
            ans[(int) (num % 10)] += point;
            num /= 10;
        }
    }
}