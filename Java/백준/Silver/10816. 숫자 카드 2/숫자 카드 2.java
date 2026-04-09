import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> cards = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int currentCard = Integer.parseInt(st.nextToken());
            cards.put(currentCard, cards.getOrDefault(currentCard, 0) + 1);
        }
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int checkingCard = Integer.parseInt(st.nextToken());
            sb.append(cards.getOrDefault(checkingCard, 0)+" ");
        }
        
        System.out.println(sb.toString());
    }
}