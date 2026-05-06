import java.util.HashSet;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashSet<Integer> winNums = new HashSet<>();
        for (int i : win_nums) {
            winNums.add(i);
        }

        int unknownCount = 0;
        int correctNumCount = 0;
        for (int i : lottos) {
            if (i == 0) {
                unknownCount++;
            } else {
                if (winNums.contains(i)) {
                    correctNumCount++;
                }
            }
        }

        
        int[] answer = new int[]{calRanking(correctNumCount + unknownCount), calRanking(correctNumCount)};
        return answer;
    }

    private int calRanking(int correctNumCount) {
        switch (correctNumCount) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}