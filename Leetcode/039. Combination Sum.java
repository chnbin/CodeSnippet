import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      List<Integer> currAns = new ArrayList<>();
      Arrays.sort(candidates);
      combSumHelper(candidates, 0, candidates.length, res, currAns, target);
      return res;
  }
  
  private void combSumHelper(int[] nums, int start, int end, List<List<Integer>> res, List<Integer> currAns, int target) {
      if (target == 0) {
          List<Integer> ans = new ArrayList<>();
          for (int i = 0; i < currAns.size(); i++) {
              ans.add(currAns.get(i));
          }
          res.add(ans);
      } else {
          for (int i = start; i < end; i++) {
              if (target >= nums[i]) {
                  target -= nums[i];
                  currAns.add(nums[i]);
                  combSumHelper(nums, i, end, res, currAns, target);
                  currAns.remove(currAns.size()-1);
                  target += nums[i];
              }
          }
      }
  }
}