import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder currentResult = new StringBuilder(st.nextToken());
            for (int j = 1; j < n; j++) {
                String currentCard = st.nextToken();
                
                if (currentCard.charAt(0) <= currentResult.charAt(0)) {
                    currentResult.insert(0, currentCard);
                } else {
                    currentResult.append(currentCard);
                }
            }
            sb.append(currentResult).append("\n");
        }
        System.out.print(sb.toString());
    }
}