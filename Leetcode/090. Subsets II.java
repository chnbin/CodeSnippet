import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      res.add(new ArrayList<Integer>());
      Arrays.sort(nums);
      subSetHelper(nums, 0, nums.length, new ArrayList<Integer>(), res);
      return res;
  }
  
  private void subSetHelper(int[] nums, int start, int end, List<Integer> tmp, List<List<Integer>> ans) {
      if (start != end) {
          Set<Integer> set = new HashSet<>();
          
          for (int i = start; i < end; i++) {
              if (!set.contains(nums[i])) {
                  set.add(nums[i]);
                  tmp.add(nums[i]);
                  ArrayList<Integer> curr = new ArrayList<>();
                  for (int j = 0; j < tmp.size(); j++) { curr.add(tmp.get(j)); }
                  ans.add(curr);
                  subSetHelper(nums, i+1, end, tmp, ans);
                  tmp.remove(tmp.size()-1);
              }
          }
      }
  }
}