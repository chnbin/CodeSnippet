import java.util.HashSet;
import java.util.Set;

class Solution {
  public int arrayNesting(int[] nums) {
      Set<Integer> set = new HashSet<>();
      int pos = 0;
      int res = 0;
      
      while (pos < nums.length) {
          if (!set.contains(nums[pos])) {
              int next = pos;
              int step = 0;
              while (!set.contains(nums[next])) {
                  set.add(nums[next]);
                  next = nums[next];
                  step++;
              }
              res = Math.max(res, step);    
          }
          pos++;
      }
      return res;
  }
}