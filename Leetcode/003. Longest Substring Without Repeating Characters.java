import java.util.HashMap;

class Solution {
  public int lengthOfLongestSubstring(String s) {
      if (s == null || s.length() == 0) { return 0; }

      HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
      int len = Integer.MIN_VALUE;
      int start = 0, end = 0;
      
      for(char c: s.toCharArray()) {
          if (!dict.containsKey(c)) {
              dict.put(c, 0);
          }
      }
      
      while (end < s.length()) {
          char endChar = s.charAt(end);
          if (dict.containsKey(endChar)) {
              dict.put(endChar, dict.get(endChar) + 1);
          }
          end++;
          
          while (dict.get(endChar) > 1) {
              char startChar = s.charAt(start);
              if (dict.containsKey(startChar)) {
                  dict.put(startChar, dict.get(startChar) - 1);
              }
              start++;
          }
          len = Math.max(len, end - start);
      }
      return len;
  }
}