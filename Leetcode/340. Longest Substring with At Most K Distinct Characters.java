import java.util.HashMap;
import java.util.Map;

class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
      if (s == null || s.length() == 0) { return 0; }
      int start = 0;
      int end = 0;
      int counter = 0;
      int maxLen = Integer.MIN_VALUE;
      Map<Character, Integer> table = new HashMap<Character, Integer>();
      
      while (end < s.length()) {
          char endChar = s.charAt(end);
          if (table.containsKey(endChar)) {
              table.put(endChar, table.get(endChar) + 1);
          } else {
              table.put(endChar, 1);
          }
          
          if (table.get(endChar) == 1) {
              counter++;
          }
          end++;
          
          while (counter > k) {
              char startChar = s.charAt(start);
              if (table.containsKey(startChar)) {
                  table.put(startChar, table.get(startChar) - 1);
                  if (table.get(startChar) == 0) {
                      counter--;
                  }
              }
              start++;
          }
          maxLen = Math.max(maxLen, end-start);
      }
      return maxLen;
  }
}