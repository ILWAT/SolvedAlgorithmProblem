import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int min = Integer.MAX_VALUE; 
        int max = Integer.MIN_VALUE;
        
        while (st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());
            if (val < min) min = val;
            if (val > max) max = val;
        }
        
        System.out.println(min + " " + max);
    }
}