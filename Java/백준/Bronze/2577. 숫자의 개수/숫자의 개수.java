import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int total = a * b * c;
        int[] numCountArr = new int[10];
        while (total > 0) {
            numCountArr[total % 10] += 1;
            total /= 10;
        }

        for (int numCount : numCountArr) {
            System.out.println(numCount);
        }
    }
}