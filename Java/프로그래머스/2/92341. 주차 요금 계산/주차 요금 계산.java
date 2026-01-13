import java.util.HashMap;
import java.util.Arrays;
import java.util.TreeMap;

class Solution {
    private int defaultMoney;
    private int defaultTime;
    private int amountMoney;
    private int amountTime;
    
    public int[] solution(int[] fees, String[] records) {
        defaultTime = fees[0];
        defaultMoney = fees[1];
        amountTime = fees[2];
        amountMoney = fees[3];
        
        HashMap<String, Integer> parkingList = new HashMap<>();
        TreeMap<String, Integer> result = new TreeMap<>();
        
        for (String record : records) {
            String[] recordCategory = record.split(" ");
            String[] timeString = recordCategory[0].split(":");
            int timeInt = timeToInt(Integer.parseInt(timeString[0]), Integer.parseInt(timeString[1]));
            String car = recordCategory[1];
            
            if (recordCategory[2].equals("IN")) {
                parkingList.put(car, timeInt);
            } else {
                int inTime = parkingList.remove(car);
                result.put(car, result.getOrDefault(car, 0) + (timeInt - inTime));
            }
        }
        
        int finalTime = timeToInt(23, 59);
        for (String car : parkingList.keySet()) {
            int inTime = parkingList.get(car);
            result.put(car, result.getOrDefault(car, 0) + (finalTime - inTime));
        }
        
        int[] answer = new int[result.size()];
        int i = 0;
        for (int time: result.values()) {
            answer[i++] = calMoney(time);
        }
        
        return answer;
    }
    
    private int timeToInt(int hour, int min) {
        return (hour * 60) + min;
    }
    
    private int calMoney(int totalTime) {
        if (totalTime <= defaultTime) return defaultMoney;
        
        return defaultMoney + (int) (Math.ceil((double)(totalTime - defaultTime) / amountTime) * amountMoney);
    }
}