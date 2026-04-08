import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            ArrayDeque<Character> ad = new ArrayDeque<>();
            String vpsCase = br.readLine();
            boolean isPossible = true;
            
            for (int index = 0; index < vpsCase.length(); index++) {
                char current = vpsCase.charAt(index);
                if (current == '(') {
                    ad.push(current);
                } else {
                    if (ad.isEmpty()) {
                        isPossible = false;
                        break;
                    }
                    ad.pop();
                }
            }
            if (ad.isEmpty() && isPossible) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}