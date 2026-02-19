import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i<n; i++) {
            ad.add(i+1);
        }

        while(ad.size() > 1) {
            if (ad.isEmpty()) break;
            ad.removeFirst();
            if (ad.size() == 1) break;
            ad.add(ad.pollFirst());
        }

        System.out.println(ad.pollFirst());
    }
}