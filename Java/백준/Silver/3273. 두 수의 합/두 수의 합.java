import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int arrLength = sc.nextInt();;
        int[] arr = new int[arrLength];
        for (int i = 0; i<arrLength; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        Arrays.sort(arr);

        int answer = 0;
        int left = 0;
        int right = arrLength - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                answer++;
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(answer);
    }
}