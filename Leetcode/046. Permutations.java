import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> ans = new ArrayList();
      permuteHelper(nums, 0, nums.length, ans);
      return ans;
  }
  
  public void permuteHelper(int[] nums, int start, int end, List<List<Integer>> ans) {
      if (start == end) {
          List<Integer> curr = new ArrayList();
          for (int num: nums) {
              curr.add(num);
          }
          ans.add(curr);
      } else {
          for (int i = start; i < end; i++) {
              swap(nums, i, start);
              permuteHelper(nums, start + 1, end, ans);
              swap(nums, i, start);
          }
      }
  }
  
  public void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
  }
}