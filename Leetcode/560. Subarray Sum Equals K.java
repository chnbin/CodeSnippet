import java.util.HashMap;
import java.util.Map;

class Solution {
  public int subarraySum(int[] nums, int k) {
      if (nums == null || nums.length == 0) {
          return 0;
      }
      Map<Integer, Integer> map = new HashMap<>();
      int res = 0;
      int prefixSum = 0;
      map.put(0, 1);
      
      for (int num: nums) {
          prefixSum += num;
          res += map.getOrDefault(prefixSum - k, 0);
          map.put(num, map.getOrDefault(prefixSum, 0) + 1);
      }
      return res;
  }
}