import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> summaryRanges(int[] nums) {
      List<String> ans = new ArrayList<String>();
      if (nums == null || nums.length == 0) { return ans; }
      int start = 0;
      int end = 0;
      
      for (int i = 0; i < nums.length; i++) {
          if (i == 0) {
              start = i;
              end = i;
          } else {
              if (nums[i] - nums[i-1] == 1) {
                  end = i;
              } else {
                  if (start == end) {
                      ans.add("" + nums[end]);
                  } else {
                      ans.add(nums[start] + "->" + nums[end]);
                  }
                  start = i;
                  end = i;
              }
          }
          
          if (i == nums.length - 1) {
              if (start == end) {
                  ans.add("" + nums[end]);
              } else {
                  ans.add(nums[start] + "->" + nums[end]);
              } 
          }
      }
      return ans;
  }
}