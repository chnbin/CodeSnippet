class Solution {
  public int[] productExceptSelf(int[] nums) {
      if (nums == null || nums.length == 0) { return nums; }
      int len = nums.length;
      int[] prefix = new int[len], postfix = new int[len],res = new int[len];
      prefix[0] = 1; 
      postfix[len-1] = 1;
      for (int i = 1; i < len; i++) {
          prefix[i] = prefix[i-1] * nums[i-1];
      }
      
      for (int i = len - 2; i >= 0; i--) {
          postfix[i] = postfix[i+1] * nums[i+1];
      }
      
      for (int i = 0; i < len; i++) {
          res[i] = prefix[i] * postfix[i];
      }
      return res;
  }
}