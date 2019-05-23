import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public String[] uncommonFromSentences(String A, String B) {
   /**
       * 1. Concatenate string A and B with space and then split it.
       * 2. Counting the appearance of each word and recording into a hashmap.
       * 3. Add the word which appears once to answer.
       */
      if (A.length() == 0 && B.length() == 0) { return new String[0]; }
      Map<String, Integer> map = new HashMap<>();
      List<String> uncommonWords = new ArrayList<>();

      String[] words = (A + " " + B).split(" ");
      
      for (String word: words) {
          if (!map.containsKey(word)) {
              map.put(word, 0);
          }
          map.put(word, map.get(word) + 1);
      }
      
      for (String key: map.keySet()) {
          if (map.get(key) == 1) {
              uncommonWords.add(key);
          }
      }
      return uncommonWords.toArray(new String[uncommonWords.size()]);
  }
}