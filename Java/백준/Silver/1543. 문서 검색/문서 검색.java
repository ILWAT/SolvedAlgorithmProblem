import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        String totalString = sc.nextLine();
        String word = sc.nextLine();
        int answer = 0;
        int index = 0;
        while (index < totalString.length()) {
            if (totalString.substring(index).startsWith(word)) {
                index += word.length();
                answer++;
            } else {
                index++;
            }
        }
        System.out.println(answer);
    }
}