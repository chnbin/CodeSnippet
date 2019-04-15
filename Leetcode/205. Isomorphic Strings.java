import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean isIsomorphic(String s, String t) {
      char[] s1 = s.toCharArray();
      char[] t1 = t.toCharArray();
      Map<Character, Character> sTot = new HashMap<Character, Character>();
      Map<Character, Character> tTos = new HashMap<Character, Character>();
      
      for (int i = 0; i < s1.length; i++) {
          if (sTot.containsKey(s1[i])) {
              if (sTot.get(s1[i]) != t1[i]) {
                  return false;
              }
          } else {
              sTot.put(s1[i], t1[i]);
          }
      }
      
      for (int i = 0; i < s1.length; i++) {
          if (tTos.containsKey(t1[i])) {
              if (tTos.get(t1[i]) != s1[i]) {
                  return false;
              }
          } else {
              tTos.put(t1[i], s1[i]);
          }
      }
      
      return true;
  }
}