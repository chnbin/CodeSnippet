import java.util.HashMap;

class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
      HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
      
      for (char c: magazine.toCharArray()) {
          if (!chars.containsKey(c)) {
              chars.put(c, 0);
          }
          chars.put(c, chars.get(c) + 1);
      }

      for (char c: ransomNote.toCharArray()) {
          if (!chars.containsKey(c) || chars.get(c) == 0) {
              return false;
          }
          chars.put(c, chars.get(c) - 1);
      }
      
      return true;
  }
}