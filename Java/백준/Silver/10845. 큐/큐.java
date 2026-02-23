import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        int count = sc.nextInt();

        for (int i = 0; i<=count; i++) {
            String[] arr = sc.nextLine().split(" ");
            String str = arr[0];
            if (str.equals("push")) {
                ad.addLast(Integer.parseInt(arr[1]));
            } else if (str.equals("pop")) {
                if (ad.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(ad.pollFirst());
                }
            } else if (str.equals("size")) {
                System.out.println(ad.size());
            } else if (str.equals("empty")) {
                System.out.println(ad.isEmpty() ? 1 : 0);
            } else if (str.equals("front")) {
                if (ad.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(ad.peekFirst());
                }
            } else if (str.equals("back")) {
                if (ad.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(ad.peekLast());
                }
            }
        }
    }
}