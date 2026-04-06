import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static int[] out;
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] visited;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        out = new int[m];
        visited = new boolean[n + 1];

        backtrack(0);
        
        System.out.println(sb.toString());
    }

    private static void backtrack(int depth) {
        if (depth == m) {
            for (int val : out) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = i;

                backtrack(depth+1);

                visited[i] = false;
            }
        }
    }
}
