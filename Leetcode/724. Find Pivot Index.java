class Solution {
  public int pivotIndex(int[] nums) {
      if (nums == null || nums.length == 0) {
          return -1;
      }
      if (nums.length == 1) {
          return 0;
      }
      int len = nums.length;
      int[] prefix = new int[len];
      int[] postfix = new int[len];
      prefix[0] = nums[0];
      postfix[len-1] = nums[len-1];
      
      for (int i = 1; i < len; i++) {
          prefix[i] = nums[i] + prefix[i-1];
      }
      
      for (int i = len - 2; i >= 0; i--) {
          postfix[i] = nums[i] + postfix[i+1];
      }
      for (int i = 0; i < len; i++){
          if (prefix[i] == postfix[i]) {
              return i;
          }
      }
      
      return -1;
  }
}