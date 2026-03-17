import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        int n = sc.nextInt();
        int[] values = new int[n];

        for (int i = 0; i<n; i++) {
            values[i] = sc.nextInt();
            ad.addLast(i);
        }

        int turn = 0;
        while (!ad.isEmpty()) {
            turn++;
            int front = ad.pollFirst();
            values[front]--;
            int fedValue = values[front];
            if (fedValue == 0) {
                values[front] = turn;
                continue;
            };
            ad.addLast(front);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<n; i++) {
            if (i != n-1) {
                sb.append(values[i] + " ");
            } else {
                sb.append(values[i]);
            }
        }

        System.out.println(sb);

    }
}