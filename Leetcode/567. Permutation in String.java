class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0;
        int end = 0;
        
        for (char c: s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int counter = map.keySet().size();
        
        while (end < s2.length()) {
            char endChar = s2.charAt(end);
            
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) {
                    counter -= 1;
                }
            }
            
            end += 1;
            
            while (counter == 0) {
                char beginChar = s2.charAt(begin);
                
                if (end - begin == s1.length()) {
                    return true;
                }
                
                if (map.containsKey(beginChar)) {
                    map.put(beginChar, map.get(beginChar) +1);
                    if (map.get(beginChar) > 0) {
                        counter++;
                    }
                }
                begin++;
            }
        }
        
        return false;
    }
}
