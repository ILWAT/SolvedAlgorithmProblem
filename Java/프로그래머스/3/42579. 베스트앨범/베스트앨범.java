import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalPlays = new HashMap<>();
        Map<String, List<Integer>> topIndices = new HashMap<>(); 

        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];

            totalPlays.put(g, totalPlays.getOrDefault(g, 0) + p);
            
            List<Integer> list = topIndices.getOrDefault(g, new ArrayList<>());
            list.add(i);
            list.sort((a, b) -> {
                if (plays[b] != plays[a]) return Integer.compare(plays[b], plays[a]); 
                return Integer.compare(a, b);
            });
            if (list.size() > 2) {
                list.subList(2, list.size()).clear();
            }
            topIndices.put(g, list);
        }

        List<String> genreOrder = new ArrayList<>(totalPlays.keySet());
        genreOrder.sort((g1, g2) -> Integer.compare(totalPlays.get(g2), totalPlays.get(g1)));

        List<Integer> answerList = new ArrayList<>();
        for (String g : genreOrder) {
            for (int idx : topIndices.get(g)) {
                answerList.add(idx);
            }
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}