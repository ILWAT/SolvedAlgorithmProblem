import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i<score.length; i++) {
            int singerS = score[i];
            if (pq.size() < k) {
                pq.add(singerS);
            } else if (pq.peek() < singerS) {
                pq.poll();
                pq.add(singerS);
            }
            answer[i] = pq.peek();
        }
        return answer;
    }
}