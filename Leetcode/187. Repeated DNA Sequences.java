import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
      Map<String, Integer> map = new HashMap<>();
      
      for (int i = 0; i <= s.length() - 10; i++) {
          String dna = s.substring(i, i + 10);
          map.put(dna, map.getOrDefault(dna, 0) + 1);
      }
      
      List<String> res = new ArrayList<>();
      
      for (String str: map.keySet()) {
          if (map.get(str) > 1) {
              res.add(str);
          }
      }
      
      return res;
  }
}