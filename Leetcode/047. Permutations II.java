import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      Arrays.sort(nums);
      helper(nums, 0, nums.length, res);
      return res;
  }
  
  private void helper(int[] nums, int start, int end, List<List<Integer>> ans) {
      if (start == end) {
          List<Integer> curr = new ArrayList<>();
          for (int num: nums) { curr.add(num); }
          ans.add(curr);
      } else {
          Set<Integer> set = new HashSet<>();
          for (int i = start; i < end; i++) {
              if (!set.contains(nums[i])) {
                  set.add(nums[i]);
                  swap(nums, i, start);
                  helper(nums, start + 1, end, ans);
                  swap(nums, i, start);
              }
          }
      }
  }
  
  private void swap(int[] arr, int i, int j) {
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
  }
}