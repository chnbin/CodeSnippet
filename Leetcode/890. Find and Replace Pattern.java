import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public List<String> findAndReplacePattern(String[] words, String pattern) {
      List<String> res = new ArrayList<>();
      String newPattern = genPattern(pattern);
      for (String word: words) {
          if (newPattern.equals(genPattern(word))) {
              res.add(word);
          }
      }
      // System.out.println(newPattern);
      return res;
  }
  
  private String genPattern(String str) {
      Map<Character, Integer> map = new HashMap<>();
      StringBuilder pattern = new StringBuilder();
      int charOrder = 0;
      for (char c: str.toCharArray()) {
          if (map.containsKey(c)) {
              pattern.append(map.get(c) + "");
          } else {
              map.put(c, charOrder);
              pattern.append(charOrder + "");
              charOrder++;
          }
      }
      return pattern.toString();
  }
}