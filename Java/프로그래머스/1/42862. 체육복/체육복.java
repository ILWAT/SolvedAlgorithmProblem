import java.util.HashSet;


class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> canReserve = new HashSet<>();
        HashSet<Integer> loster = new HashSet<>();
        
        for (int losted : lost) {
            loster.add(losted);
        }
        for (int server : reserve) {
            canReserve.add(server);
        }
        
        for (int lostedPerson : lost) {
            if (canReserve.contains(lostedPerson)) {
                canReserve.remove(lostedPerson);
                loster.remove(lostedPerson);
            }
        }
        
        int answer = n - loster.size();
        for (int i = 1; i <= n; i++) {
            if (loster.contains(i)) {
                if (canReserve.contains(i - 1)) {
                    answer++;
                    canReserve.remove(i - 1);
                } 
                else if (canReserve.contains(i + 1)) {
                    answer++;
                    canReserve.remove(i + 1);
                }
            }
        }
        
        return answer;
    }
}