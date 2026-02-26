import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        int qNum = sc.nextInt();
        sc.nextLine();

        HashMap<String, String> personHashMap = new HashMap<>();
        HashMap<String, ArrayList<String>> teamMap = new HashMap<>();

        for (int i = 0; i<inputNum; i++) {
            String teamString = sc.nextLine();
            int teamMemberLength = sc.nextInt();
            sc.nextLine();

            ArrayList<String> members = new ArrayList<>();
            for (int j=0; j<teamMemberLength; j++) {
                String memberName = sc.nextLine();
                members.add(memberName);
                personHashMap.put(memberName, teamString);
            }

            Collections.sort(members);
            teamMap.put(teamString, members);
        }

        for (int q = 0; q<qNum; q++) {
            String qString = sc.nextLine();
            int type = sc.nextInt();
            sc.nextLine();
            if(type == 0) {
                ArrayList<String> answerList = teamMap.get(qString);
                for (String answer: answerList) {
                    System.out.println(answer);
                }
            } else {
                String answer = personHashMap.get(qString);
                System.out.println(answer);
            }
        }
    }
}