import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
       return (int) (zacard(divide(str1.toLowerCase()), divide(str2.toLowerCase())) * 65536);
    }
    
    private String[] divide(String s) {
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            
            if (c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z') {
                al.add("" + c1 + c2);
            }
        }
        return al.toArray(new String[0]);
    }
    
    private double zacard(String[] str1, String[] str2) {
        if (str1.length == 0 && str2.length == 0) return 1.0;
        
        HashMap<String, Integer> a = new HashMap<>();
        HashMap<String, Integer> b = new HashMap<>();
        
        for (String str : str1) {
            a.put(str, a.getOrDefault(str, 0) + 1);
        }
        
        for (String str : str2) {
            b.put(str, b.getOrDefault(str, 0) + 1);
        }
        
        int intersectionCount = 0;
        int unionCount = 0;
        
        Set<String> all = new HashSet<>();
        all.addAll(a.keySet());
        all.addAll(b.keySet());
        
        for (String key : all) {
            int count1 = a.getOrDefault(key, 0);
            int count2 = b.getOrDefault(key, 0);
            
            intersectionCount += Math.min(count1, count2);
            unionCount += Math.max(count1, count2);
                
        }
        
        return (double) intersectionCount / unionCount;
        
    }
}