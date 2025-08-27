import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> waitingTruck = new ArrayDeque<>();
        for (int w : truck_weights) {
            waitingTruck.add(w);
        }
        
        ArrayDeque<Integer> outBridgeTime = new ArrayDeque<Integer>();
        ArrayDeque<Integer> onBridge = new ArrayDeque<Integer>();
        int currentWeight = 0;
        int currentTime = 0;
        int destinationCount = 0;
        
        while (destinationCount < truck_weights.length) {
            if (!onBridge.isEmpty() && outBridgeTime.peekFirst() == currentTime) {
                outBridgeTime.pollFirst();
                currentWeight -= onBridge.pollFirst();
                destinationCount++;
            }
            
            if (!waitingTruck.isEmpty() && currentWeight+waitingTruck.peekFirst() <= weight && onBridge.size() < bridge_length) {
                outBridgeTime.addLast(currentTime+bridge_length);
                int truck = waitingTruck.pollFirst();
                onBridge.addLast(truck);
                currentWeight += truck;
            }
            
            currentTime++;
        }

        return currentTime;
    }
}