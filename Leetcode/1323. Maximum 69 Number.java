class Solution {
  public int maximum69Number (int num) {
      // 遇到第一個六改成九
      char[] nums = ("" + num).toCharArray();
      for (int i = 0; i < nums.length; i++) {
          if (nums[i] == '6') {
              nums[i] = '9';
              break;
          }
      }
      
      /* int res = 0;
      
      for (int i = 0; i < nums.length; i++) {
          res *= 10;
          res += (nums[i] - '0');
      } */
      
      // return res;
      return Integer.parseInt(new String(nums));
  }
}