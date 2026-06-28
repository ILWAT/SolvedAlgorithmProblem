import java.util.*;

class Solution {
    ArrayList<String> allPaths = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        
        for (String[] ticket : tickets) {
            ArrayList<String> list = hm.getOrDefault(ticket[0], new ArrayList<>());
            list.add(ticket[1]);
            hm.put(ticket[0], list);
        }
        
        HashMap<String, boolean[]> visited = new HashMap<>();
        for (Map.Entry<String, ArrayList<String>> entry : hm.entrySet()) {
            Collections.sort(entry.getValue());
            visited.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }
        
        dfs("ICN", "ICN", hm, visited, tickets.length, 0);
        
        String[] answer = allPaths.get(0).split(" ");
        return answer;
    }
    
    private void dfs(String current, String path, HashMap<String, ArrayList<String>> hm, HashMap<String, boolean[]> visited, int totalTickets, int count) {
        if (count == totalTickets) {
            allPaths.add(path);
            return;
        }
        
        if (!hm.containsKey(current)) return;
        
        ArrayList<String> neighbors = hm.get(current);
        boolean[] isVisited = visited.get(current);
        
        for (int i = 0; i < neighbors.size(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                String next = neighbors.get(i);
                
                dfs(next, path + " " + next, hm, visited, totalTickets, count + 1);
                
                isVisited[i] = false;
            }
        }
    }
}