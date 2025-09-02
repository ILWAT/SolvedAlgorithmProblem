import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> part = new HashMap<>();
        for (String person : participant) {
            part.put(person, part.getOrDefault(person, 0)+1);
        }
        
        for (String completePerson: completion) {
            int remainedPerson = part.getOrDefault(completePerson, 0);
            if(remainedPerson <= 1) {
                part.remove(completePerson);
            } else {
                part.replace(completePerson, remainedPerson - 1);
            }
        }
        
        for (String person: part.keySet()) {
            return person;
        }
        return "";
    }
}