import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        
        Integer[] ropes = new Integer[n];
        for (int i = 0; i<n; i++) {
            int input = sc.nextInt();
            sc.nextLine();
            ropes[i] = input;
        }

        Arrays.sort(ropes, Collections.reverseOrder());

        int maxWeight = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++) {
            int currentWeight = ropes[i] * (i+1);

            if (currentWeight > maxWeight) {
                maxWeight = currentWeight;
            }
        }

        System.out.println(maxWeight);
    }
}