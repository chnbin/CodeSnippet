import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean wordPattern(String pattern, String str) {
      String[] strs = str.split(" ");
      if (pattern.length() != strs.length) { return false; }
      Map<Character, String> map = new HashMap<>();
  
      for (int i = 0; i < pattern.length(); i++) {
          char pChar = pattern.charAt(i);
          if (map.containsKey(pChar)) {
              if (!map.get(pChar).equals(strs[i])) {
                  return false;
              }
          } else {
              if (map.containsValue(strs[i])) {
                  return false;
              }
              map.put(pChar, strs[i]);
          }
      }
      return true;
  }
}