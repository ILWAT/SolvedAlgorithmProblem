import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] rank = new String[players.length];
        HashMap<String, Integer> playerMap = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            String player = players[i];
            rank[i] = player;
            playerMap.put(player, i);
        }
        
        for (String name : callings) {
            int index = playerMap.getOrDefault(name, players.length);
            if (index >= players.length) {
                continue;
            }
            String frontP = rank[index - 1];
            rank[index] = frontP;
            rank[index - 1] = name;
            playerMap.put(frontP, index);
            playerMap.put(name, index - 1);
        }
        
        return rank;
    }
}