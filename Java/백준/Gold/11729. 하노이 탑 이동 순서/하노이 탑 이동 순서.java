import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int count = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        hanoi(n, 1, 2, 3);

        System.out.print(count + "\n" + sb.toString());
    }

    public static void hanoi(int board, int s, int v, int e) {
        count++;
        if (board == 1) {
            sb.append(s + " " + e + "\n");
            return;
        }

        hanoi(board - 1, s, e, v);

        sb.append(s + " " + e + "\n");

        hanoi(board - 1, v, s, e);
    }
}