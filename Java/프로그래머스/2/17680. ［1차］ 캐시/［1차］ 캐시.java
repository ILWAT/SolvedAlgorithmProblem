import java.util.ArrayDeque;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize <= 0) {
            return cities.length * 5;
        }
        
        int answer = 0;
        ArrayDeque<String> ad = new ArrayDeque<>();
        for (String city : cities) {
            String CITY = city.toUpperCase();
            if (ad.contains(CITY)) {
                answer += 1;
                ad.remove(CITY);
            } else {
                answer += 5;
            }
            
            ad.add(CITY);
            while (ad.size() > cacheSize) {
                ad.removeFirst();
            }
        }
        return answer;
    }
}