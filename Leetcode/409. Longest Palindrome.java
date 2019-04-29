import java.util.HashMap;
import java.util.Map;

class Solution {
  public int longestPalindrome(String s) {
      if (s == null || s.length() == 0) { return 0; }
      Map<Character, Integer> map = new HashMap<>();
      int odd = 0;
      int res = 0;

      for (char c: s.toCharArray()) {
          if (!map.containsKey(c)) {
              map.put(c, 0);
          }
          map.put(c, map.get(c) + 1);
      }
      
      for (int count: map.values()) {
          if (count % 2 == 0) {
              res += count;
          } else {
              res += (count - 1);
              odd = 1;
          }
      }
      return res + odd;
  }
}