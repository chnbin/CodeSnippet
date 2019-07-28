import java.util.HashMap;
import java.util.Map;

class Solution {
  public int largestUniqueNumber(int[] A) {
      Map<Integer, Integer> map = new HashMap<>();
      int res = -1;
      
      for (int num: A) {
          map.put(num, map.getOrDefault(num, 0) + 1);
      }
      
      for (int key: map.keySet()) {
          if (map.get(key) == 1) {
              res = Math.max(res, key);
          }
      }
      return res;
  }
}