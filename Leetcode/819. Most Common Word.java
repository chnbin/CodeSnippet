import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
  public String mostCommonWord(String paragraph, String[] banned) {
      Set<String> bannedSet = new HashSet<>();
      Map<String, Integer> map = new HashMap<>();
      StringBuilder sb = new StringBuilder();
      int maxLen = 0;
      String res = "";
      
      for (String ban: banned) {
          // System.out.println(ban.toLowerCase());
          bannedSet.add(ban.toLowerCase());
      }
      
      for (int i = 0; i < paragraph.length(); i++) {
          char c = paragraph.charAt(i);
          if (Character.isLetter(c)) {
              sb.append(c);
          }
          if (!Character.isLetter(c) || i == paragraph.length() - 1) {
              String word = sb.toString().toLowerCase();
              if (word.length() > 0 && !bannedSet.contains(word)) {
                  map.put(word, map.getOrDefault(word, 0) + 1);
                  
                  if (map.get(word) > maxLen) {
                      maxLen = map.get(word);
                      res = word;
                  }
              }
              sb = new StringBuilder();
          }
      }
      return res;
  }
}