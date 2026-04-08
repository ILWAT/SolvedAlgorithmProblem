import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            hm.put(st.nextToken(), st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(hm.getOrDefault(br.readLine(), "") + "\n");
        }
        System.out.print(sb.toString());
    }
}