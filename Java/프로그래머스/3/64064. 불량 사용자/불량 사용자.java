import java.util.HashSet;

class Solution {
    private int userLength;
    private int bannedLength;
    private int answer = 0;
    private HashSet<HashSet<String>> answerSet;
    
    public int solution(String[] user_id, String[] banned_id) {
        userLength = user_id.length;
        bannedLength = banned_id.length;
        answerSet = new HashSet<>();
        
        findAnswer(user_id, banned_id, 0, new HashSet<String>());
        
        return answer;
    }
    
    private void findAnswer(String[] user_id, String[] banned_id, int bannedIndex, HashSet<String> set) {
        if (bannedLength == bannedIndex) {
            if (!answerSet.contains(set)) {
                answerSet.add(new HashSet<>(set));
                answer++;
            }
            return;
        }
        
        for (int i = 0; i < userLength; i++) {
            if (!set.contains(user_id[i]) && isMatched(user_id[i], banned_id[bannedIndex])) {
                set.add(user_id[i]);
                findAnswer(user_id, banned_id, bannedIndex + 1, set);
                set.remove(user_id[i]);
            }
        }
        
        return;
    }
    
    
    private boolean isMatched(String user, String banned) {
        if (user.length() != banned.length()) return false;
        
        for (int i = 0; i < user.length(); i++) {
            char nbc = banned.charAt(i); // now banned char
            if (nbc == '*') {
                continue;
            } else if (nbc == user.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }
        
        return true;
    }
}