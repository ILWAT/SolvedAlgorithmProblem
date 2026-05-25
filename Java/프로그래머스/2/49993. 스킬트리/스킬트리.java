import java.util.HashSet;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        char[] skillTree = new char[skill.length()];
        HashSet<Character> treeSet = new HashSet<>();
        for (int i = 0; i < skill.length(); i++) {
            char c = skill.charAt(i);
            treeSet.add(c);
            skillTree[i] = c;
        }
        
        int answer = 0;
        for (String skill_tree : skill_trees) {
            boolean isEnabled = true;
            int skillIndex = 0;
            for (char Skill : skill_tree.toCharArray()) {
                if (treeSet.contains(Skill)) {
                    if (skillTree[skillIndex] == Skill) {
                        if (skillIndex < skillTree.length - 1) skillIndex++;
                    } else {
                        isEnabled = false;
                        break;
                    }
                }
            }
            if (isEnabled) answer++;
        }
        return answer;
    }
}