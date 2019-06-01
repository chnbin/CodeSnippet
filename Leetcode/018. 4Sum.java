import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
      List<List<Integer>> res = new ArrayList<>();
      if (nums == null || nums.length < 4) { return res; }
      Arrays.sort(nums);
      
      for (int i = 0; i < nums.length - 3; i++) {
          // Skip repeated elements
          if (i == 0 || (nums[i] != nums[i-1])) {
              for (int j = i + 1; j < nums.length - 2; j++) {
                  // Skip repeated element
                  if (j == i + 1 || nums[j] != nums[j-1]) {
                      int left = j + 1;
                      int right = nums.length - 1;
                      int newTarget = target - nums[i] - nums[j];
                      while (left < right) {
                          if (nums[left] + nums[right] == newTarget) {
                              res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                              // Skip repeated element
                              while (left < right && nums[left] == nums[left+1]) { left++; }
                              while (left < right && nums[right] == nums[right-1]) { right--; }
                              left++;
                              right--;
                          } else if (nums[left] + nums[right] > newTarget) {
                              right--;
                          } else {
                              left++;
                          }
                      }
                  }
              }
          }
      }
      return res;
  }
}