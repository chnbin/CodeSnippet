class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c: p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int n = s.length();
        int endPos = 0;
        int beginPos = 0;
        int counter = map.keySet().size();
        
        while (endPos < n) {
            char endChar = s.charAt(endPos);
            // System.out.println(endChar);
            // System.out.println(map.get(endChar));
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) {
                    counter--;
                }
            }
            
            endPos++;
            
            // System.out.println(counter);
            while (counter == 0) {
                if (endPos - beginPos == p.length()) {
                    res.add(beginPos);
                }
                
                char beginChar = s.charAt(beginPos);
                
                if (map.containsKey(beginChar)) {
                    map.put(beginChar, map.get(beginChar) + 1);
                    if (map.get(beginChar) > 0) {
                        counter++;   
                    }
                }
                
                beginPos++;
            }
            
        }
        
        return res;
    }
}
