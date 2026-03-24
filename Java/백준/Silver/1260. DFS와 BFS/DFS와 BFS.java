import java.util.*;

public class Main {
    public static boolean[] visited;
    public static boolean[] visited2;
    public static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n];
        visited2 = new boolean[n];

        for (int i = 0; i<m; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            graph.get(first-1).add(second-1);
            graph.get(second-1).add(first-1);
        }

        for (int i = 0; i<n; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(v-1);
        System.out.println();
        bfs(v-1);
        System.out.println();
    }

    public static void dfs(int node) {
        visited[node] = true;
        System.out.print((node+1) + " ");

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
           }
        }
    }

    public static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        visited2[start] = true;

        while (!queue.isEmpty()) {
           int node = queue.pollFirst();
           System.out.print((node+1) + " ");

          for (int next : graph.get(node)) {
              if (!visited2[next]) {
                visited2[next] = true;
                queue.addLast(next);
              }
            }
        } 
    }
}
