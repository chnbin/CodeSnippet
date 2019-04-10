import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> ans = new ArrayList<List<Integer>>();
      List<Integer> currAns = new ArrayList<Integer>();
      ans.add(new ArrayList<Integer>());
      subsetsHelper(nums, 0, nums.length, ans, currAns);
      return ans;
  }
  
  public void subsetsHelper(int[] nums, int start, int end, List<List<Integer>> ans, List<Integer> currAns) {
      if (start == end) {
          return ;
      } else {
          for(int i = start; i < end; i++) {
              currAns.add(nums[i]);
              List<Integer> tmp = new ArrayList<Integer>();
              for(int num: currAns) {
                  tmp.add(num);
              }
              ans.add(tmp);
              subsetsHelper(nums, i + 1, end, ans, currAns);
              currAns.remove(currAns.size() - 1);
          }
      }
  }
}