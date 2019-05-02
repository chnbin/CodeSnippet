import java.util.HashMap;
import java.util.Map;

class Solution594 {
  public int findLHS(int[] nums) {
      if (nums == null || nums.length == 0) {
          return 0;
      }
      Map<Integer, Integer> map = new HashMap<>();
      int res = 0;
      
      for (int num: nums) {
          if (!map.containsKey(num)) {
              map.put(num, 0);
          }
          map.put(num, map.get(num)+1);
      }
      
      for (int key: map.keySet()) {
          if (map.containsKey(key + 1)) {
              res = Math.max(res, map.get(key) + map.get(key+1));
          }
      }
      
      return res;
  }
}