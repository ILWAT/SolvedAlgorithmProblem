import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] visited;
    private static LinkedList<Integer>[] linkedList;
    private static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        linkedList = new LinkedList[node+1];
        for (int i = 0; i < node+1; i++) {
            linkedList[i] = new LinkedList<>();
        }
        visited = new boolean[node+1];
        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            linkedList[node1].add(node2);
            linkedList[node2].add(node1);
        }

        dfs(1);
        System.out.println(answer-1);
    }

    private static void dfs(int node) {
        visited[node] = true;
        answer++;
        for (Integer linked : linkedList[node]) {
            if (!visited[linked]) {
                dfs(linked);
            }
        }
    }
}