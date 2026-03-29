import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> intAL = new ArrayList<>();
            while (st.hasMoreTokens()) {
                intAL.add(Integer.parseInt(st.nextToken()));
            }

            int maxGCD = 0;

            for (int j = 0; j<intAL.size(); j++) {
                for (int k = j+1; k<intAL.size(); k++) {
                    int currentGCD = Euclidean(intAL.get(j), intAL.get(k));
                    maxGCD = Math.max(maxGCD, currentGCD);
                }
            }

            if (i == n-1) {
                sb.append(maxGCD);
            } else {
                sb.append(maxGCD+"\n");
            }
            
        }

        System.out.println(sb.toString());
    }
    
    private static int Euclidean(int a, int b) {
        if (b == 0) return a;
        return Euclidean(b, a % b);
    }
}