import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
 
        int pointer1 = 0;
        int pointer2 = 0;
        
        int answer = Integer.MAX_VALUE;
        while (pointer1 < n && pointer2 < n) {
            int diff = arr[pointer2] - arr[pointer1];

            if (diff >= m) {
                answer = Math.min(answer, diff);

                pointer1++;

                if (answer == m) break;
            } else {
                pointer2++;
            }
        }

        System.out.println(answer);
    }
}