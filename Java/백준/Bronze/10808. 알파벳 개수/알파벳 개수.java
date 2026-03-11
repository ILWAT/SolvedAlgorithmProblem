import java.util.*;

public class Main {
    public static void main(String[] args) {
        int a = 'a';
        int z = 'z';
        int total = z - a + 1;
        int[] countArr = new int[total];

        Scanner sc = new Scanner(System.in);
        char[] cArr = sc.nextLine().toCharArray();
        for (int i = 0; i<cArr.length; i++) {
            int cInt = cArr[i];
            int index = cInt-a;
            countArr[index] += 1;
        }

        for (int i = 0; i < countArr.length; i++) {
            if (i == countArr.length - 1) {
                System.out.println(countArr[i]);
            } else {
                System.out.print(countArr[i] + " ");
            }
        }                   
    }
}