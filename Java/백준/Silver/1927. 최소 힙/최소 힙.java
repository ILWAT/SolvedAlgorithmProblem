import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll()+"\n");
                } else {
                    sb.append(0+"\n");
                }
            } else {
                pq.add(input);
            }
        }
        System.out.println(sb.toString());
    }
}