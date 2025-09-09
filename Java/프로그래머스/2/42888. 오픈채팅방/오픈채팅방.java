import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> user = new HashMap<>();
        
        for (String commandLine: record) {
            String[] splited = commandLine.split(" ");
            if (splited[0].equals("Enter") || splited[0].equals("Change")) {
                user.put(splited[1], splited[2]);
            }
        }
        
        ArrayList<String> message = new ArrayList<>();
         for (String commandLine: record) {
            String[] splited = commandLine.split(" ");
            if (splited[0].equals("Enter")) {
                message.add(user.getOrDefault(splited[1], "")+"님이 들어왔습니다.");
            } else if (splited[0].equals("Leave")) {
                message.add(user.getOrDefault(splited[1], "")+"님이 나갔습니다.");
            }
        }
        return message.toArray(new String[0]);
    }
}