import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
  public boolean canConvert(String str1, String str2) {
      if (str1.length() != str2.length()) { return false; }
      if (str1.equals(str2)) { return true; }
      
      Map<Character, Character> map = new HashMap<>();
      
      for (int i = 0; i < str1.length(); i++) {
          char a = str1.charAt(i);
          char b = str2.charAt(i);
          
          if (map.containsKey(a)) {
              if (map.get(a) != b) {
                  return false;
              }
          }
          map.put(a, b);
      }
      
      Set<Character> set = new HashSet<>();
      for (Character c: map.values()) {
          set.add(c);
      }
      
      return set.size() != 26;
  }
}