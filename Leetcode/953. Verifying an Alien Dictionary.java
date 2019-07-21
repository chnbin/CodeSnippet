import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean isAlienSorted(String[] words, String order) {
      Map<Character, Integer> map = new HashMap<>();
      
      // Build order.
      for (int i = 0; i < order.length(); i++) {
          map.put(order.charAt(i), i);
      }
      
      for (int i = 1; i < words.length; i++) {
          if (!isOrder(words[i-1], words[i], map)) {
              return false;
          }
      }
      return true;
  }
  
  private boolean isOrder(String str1, String str2, Map<Character, Integer> map) {
      int pos = 0;
      
      while (pos < str1.length() && pos < str2.length()) {
          char ch1 = str1.charAt(pos);
          char ch2 = str2.charAt(pos);
          int idx1 = map.get(ch1);
          int idx2 = map.get(ch2);
          
          if (idx1 < idx2) { return true; }
          if (idx1 > idx2) { return false; }
          
          pos++;
      }
      
      // For "apple", "app" case
      // null is the smallest order
      return str1.length() <= str2.length();
  }
}