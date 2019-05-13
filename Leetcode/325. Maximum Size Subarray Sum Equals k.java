import java.util.HashMap;
import java.util.Map;

class Solution {
  /**
  * Familiar with 560.Subarray Sum Equals K
  * pre - k = diffrence of current prefix and tager k, if pre-k existed in map
  * then the sum from map(pre-k) to i is target k we should keep it.
  * index   -1.   0      1     2.  3
  *              -2     -1     2   1.  k = 1
  *.prefix   0
  * map   <0,-1>
  * prefix       -2
  * map   <0,-1> <-2,1>
  * prefix              -3
  * map   <0,-1> <-2,0><-3,1>
  * prefix                    -1      map.containsKey(pre-k) maxLen = 2
  * map   <0,-1> <-2,0><-3,1><-1,2>
  * prefix                         2
  */
  public int maxSubArrayLen(int[] nums, int k) {
      if (nums == null || nums.length == 0) {
          return 0;
      }
      Map<Integer,Integer> map = new HashMap<>();
      map.put(0, -1);
      int prefix = 0;
      int maxLen = 0;
      
      for (int index = 0; index < nums.length; index++) {
          prefix += nums[index];
          if (map.containsKey(prefix - k)) {
              maxLen = Math.max(maxLen, index - map.get(prefix - k));
          }
          // If prefix is already exits in map, we will not update it because
          // keep to longer. (Try nums = [1, -1, 5, -2, 3], k = 3)
          if (!map.containsKey(prefix)) {
              map.put(prefix, index);
          }
      }
      return maxLen;
  }
}


