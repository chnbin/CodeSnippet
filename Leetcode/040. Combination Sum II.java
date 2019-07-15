import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      List<Integer> currAns = new ArrayList<Integer>();
      Arrays.sort(candidates);
      combSumHelper(candidates, target, 0, candidates.length, res, currAns);
      return res;
  }
  
  private void combSumHelper(int[] nums, int target, int start, int end, List<List<Integer>> res, List<Integer> currAns) {
      if (target == 0) {
          List<Integer> ans = new ArrayList<>();
          for (int i = 0; i < currAns.size(); i++) {
              ans.add(currAns.get(i));
          }
          res.add(ans);
      } else {
          Set<Integer> set = new HashSet<>();
          for (int i = start; i < end; i++) {
              if (!set.contains(nums[i])) {
                  set.add(nums[i]);
                  if (target >= nums[i]) {
                      target -= nums[i];
                      currAns.add(nums[i]);
                      combSumHelper(nums, target, i+1, end, res, currAns);
                      currAns.remove(currAns.size()-1);
                      target += nums[i];
                  }
              }    
          }
      }
  }
}