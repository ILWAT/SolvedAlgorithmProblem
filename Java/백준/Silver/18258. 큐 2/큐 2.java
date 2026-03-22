import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalInput = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totalInput; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.contains("push")) {
                ad.addLast(Integer.parseInt(st.nextToken()));
                continue;
            } else if (command.contains("pop")) {
                if (ad.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(ad.pollFirst());
                }
            } else if (command.contains("size")) {
                sb.append(ad.size());
            } else if (command.contains("empty")) {
                 sb.append(ad.isEmpty() ? 1 : 0);
            } else if (command.contains("front")) {
                if (ad.isEmpty()) {
                    sb.append("-1");
                } else {
                    sb.append(ad.peekFirst());
                }
            } else if (command.contains("back")) {
                if (ad.isEmpty()) {
                    sb.append("-1");
                } else {
                    sb.append(ad.peekLast());
                }
            }

            if (i != totalInput-1) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}