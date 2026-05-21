import java.util.*;
import java.io.*;

class Solution {
    private HashMap<String, Integer> peopleDic = new HashMap<>();
    
    public int solution(String[] friends, String[] gifts) {
        int friendsLength = friends.length;
        for (int i = 0; i < friendsLength; i++) {
            peopleDic.put(friends[i], i);
        }
        
        int[][] giftMatrix = new int[friendsLength][friendsLength];
        int[][] scoreArr = new int[friendsLength][3];
        
        for (String gift : gifts) {
            StringTokenizer st = new StringTokenizer(gift);
            int giverIndex = peopleDic.get(st.nextToken());
            int receiverIndex = peopleDic.get(st.nextToken());
            giftMatrix[giverIndex][receiverIndex] = giftMatrix[giverIndex][receiverIndex] + 1;
            scoreArr[giverIndex][0] = scoreArr[giverIndex][0] + 1;
            scoreArr[receiverIndex][1] = scoreArr[receiverIndex][1] + 1;
        }
        
        for (int i = 0; i < friendsLength; i++) {
            scoreArr[i][2] = scoreArr[i][0] - scoreArr[i][1];
        }
        
        int answer = 0;
        for (int giver = 0; giver < friendsLength; giver++) {
            int rxGift = 0;
            for (int receiver = 0; receiver < friendsLength; receiver++) {
                if (giver == receiver) continue;
                if ((giftMatrix[giver][receiver] == 0 && giftMatrix[receiver][giver] == 0) || giftMatrix[giver][receiver] == giftMatrix[receiver][giver]) {
                    if (scoreArr[giver][2] > scoreArr[receiver][2]) {
                        rxGift++;
                    }
                } else if (giftMatrix[giver][receiver] > giftMatrix[receiver][giver]) {
                    rxGift++;
                }
            }
            answer = Math.max(answer, rxGift);
        }
        
        
        return answer;
    }
}