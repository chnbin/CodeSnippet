import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public List<List<Integer>> findSubsequences(int[] nums) {
      List<Integer> tmp = new ArrayList<>();
      Set<List<Integer>> ans = new HashSet<List<Integer>>();
      findHelper(nums, 0, nums.length, tmp, ans);
      return new ArrayList(ans);
  }
  
  private void findHelper(int[] nums, int start, int end, List<Integer> tmp, Set<List<Integer>> ans) {
      if (start == end) {
          return ;
      } else {
          for (int i = start; i < end; i++) {
              if (tmp.size() == 0 || nums[i] >= tmp.get(tmp.size()-1)) {
                  tmp.add(nums[i]);
                  if (tmp.size() >= 2) {
                      List<Integer> curr = new ArrayList<>();
                      for (int j = 0; j < tmp.size(); j++) {
                          curr.add(tmp.get(j));
                      }
                      ans.add(curr);
                  }
                  findHelper(nums, i + 1, end, tmp, ans);
                  tmp.remove(tmp.size()-1);
              }
          }
      }
  }
}