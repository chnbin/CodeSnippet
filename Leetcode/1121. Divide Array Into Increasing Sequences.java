import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean canDivideIntoSubsequences(int[] nums, int K) {
      // 遞增陣列
      // 整個題目看起來很難，其實可以分的組數取決於相同數字的最大值
      Map<Integer, Integer> map = new HashMap<>();
      
      for (int num: nums) {
          map.put(num, map.getOrDefault(num, 0) + 1);
      }
      
      int maxGroup = 0;
      
      for (int n: map.values()) {
          maxGroup = Math.max(maxGroup, n);
      }
      
      return (nums.length >= K*maxGroup);
  }
}