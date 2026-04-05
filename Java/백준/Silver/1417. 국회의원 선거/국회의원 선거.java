import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] person = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int result = 0;
        int dasom = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        while (!pq.isEmpty() && dasom <= pq.peek()) {
            int maxPerson = pq.poll();
            dasom++;
            result++;
            pq.add(--maxPerson);
        }
        
        System.out.println(result);
    }
}