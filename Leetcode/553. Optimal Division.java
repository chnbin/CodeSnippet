class Solution {
  public String optimalDivision(int[] nums) {
      if (nums.length == 1) { return ("" + nums[0]); }
      if (nums.length == 2) { return ("" + nums[0] + "/" +nums[1]); }
      StringBuilder res = new StringBuilder();
      res.append("" + nums[0] + "/(");
      
      for (int i = 1; i < nums.length; i++) {
          if (i != nums.length - 1) {
              res.append("" + nums[i] + "/");
          } else {
              res.append("" + nums[i] + ")");
          }
      }
      return res.toString();
  }
}