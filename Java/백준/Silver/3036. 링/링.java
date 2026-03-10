import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int mainR = sc.nextInt();

        for (int i = 0; i<n-1; i++) {
            int subR = sc.nextInt();

            int gcdValue = gcd(mainR, subR);

            System.out.println((mainR/gcdValue) + "/" + (subR/gcdValue));
        }
    }

    private static int gcd(int i, int j) {
        while (j != 0) {
            int r = i % j;
            i = j;
            j = r;
        }
        return i;
    }
}