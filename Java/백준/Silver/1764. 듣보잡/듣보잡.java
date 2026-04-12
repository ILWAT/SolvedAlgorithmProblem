import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<String>();

        for (int i = 0; i < N; i++) {
            String person = br.readLine();
            set.add(person);
        }

        StringBuilder sb = new StringBuilder();
        ArrayList<String> dbj = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < M; i++) {
             String person = br.readLine();
             if (set.contains(person)) {
                dbj.add(person);
             }
        }

        Collections.sort(dbj);

        sb.append(dbj.size() + "\n");
        for (String dbjPerson : dbj) {
            sb.append(dbjPerson + "\n");   
        }

        System.out.print(sb.toString());
    }
}