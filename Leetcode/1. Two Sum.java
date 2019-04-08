import java.util.HashMap;
class Solution {
  public int[] twoSum(int[] nums, int target) {
      HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
      int[] ans = {-1, -1};
      
      for (int i = 0; i < nums.length; i++) {
          int remain = target - nums[i];
          if (dict.containsKey(remain)) {
              ans[0] = dict.get(remain);
              ans[1] = i;
              return ans;
          } else {
              dict.put(nums[i], i);
          }
      }
      return ans;
  }
}