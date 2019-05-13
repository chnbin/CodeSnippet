import java.util.HashMap;
import java.util.Map;

class Solution {
  public int findMaxLength(int[] nums) {
      if (nums == null || nums.length == 0) {
          return 0;
      }
      
      Map<Integer, Integer> map = new HashMap<>();
      int maxLen = 0;
      int prefix = 0;

      for (int index = 0; index < nums.length; index++) {
          // Treat 0 as -1
          prefix += (nums[index] == 0) ? -1 : 1;
          
          // Special case
          if (prefix == 0) {
              maxLen = index + 1;
          } else if (map.containsKey(prefix)) {
              maxLen = Math.max(maxLen, index - map.get(prefix));
          }
          
          if (!map.containsKey(prefix)) {
              map.put(prefix, index);
          }
      }
      return maxLen;
  }
}