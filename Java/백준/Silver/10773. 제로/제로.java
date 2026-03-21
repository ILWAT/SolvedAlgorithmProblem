import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int inputInt = sc.nextInt();
            if (inputInt == 0 && !ad.isEmpty()) {
                ad.pollLast();
            } else {
                ad.addLast(inputInt);
            }
        }

        int result = 0;
        while (!ad.isEmpty()) {
            result += ad.pollFirst();
        }

        System.out.println(result);
    }
}