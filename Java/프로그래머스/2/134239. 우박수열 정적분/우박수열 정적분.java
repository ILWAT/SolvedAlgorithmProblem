import java.util.*;

class Solution {
    int N = 0;
    public double[] solution(int k, int[][] ranges) {
        int[] c = collatz(k);
        double[] answer = new double[ranges.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = calculateArea(ranges[i], c);
        }
        return answer;
    }
    
    private int[] collatz(int n) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(n);
        while (n > 1) {
            n = divide(n);
            al.add(n);
        }
        N = al.size();
        return al.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int divide(int n) {
        return (n % 2 == 0) ? (n / 2) : ((n * 3) + 1);
    }
    
    private double calculateArea(int[] r, int[] c) {
        int a = r[0];
        int b = r[1];
        double result = 0;
        int x1 = a;
        int x2 = (N - 1) + b;
        if (x1 > x2) {
            return -1.0;
        }
        if (x1 == x2) {
            return 0.0; 
        }
        for (int i = x1; i < x2; i++) {    
            result += calArea(c[i], c[i+1]);
        }
        return result;
    }
    
    private double calArea(int y1, int y2) {
        int minY = Math.min(y1, y2);
        int maxY = Math.max(y1, y2);
        double squareArea = (double) minY;
        double triangleArea = (maxY - minY) / 2.0;
        return squareArea + triangleArea;
    }
}