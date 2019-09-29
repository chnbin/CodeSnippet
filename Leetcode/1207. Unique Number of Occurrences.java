import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
  public boolean uniqueOccurrences(int[] arr) {
      Map<Integer, Integer> map = new HashMap<>();
      Set<Integer> set = new HashSet<>();
      
      for (int n: arr) {
          map.put(n, map.getOrDefault(n, 0) + 1);
      }
      
      for (int key: map.keySet()) {
          int cnt = map.get(key);
          
          if (!set.contains(cnt)) {
              set.add(cnt);
          } else {
              return false;
          }
      }
      return true;
  }
}