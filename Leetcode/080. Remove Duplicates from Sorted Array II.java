class Solution {
  public int removeDuplicates(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      if (nums.length < 2) return nums.length;

      int pos = 2; // Store nums[0], nums[1] definitely
      
      for (int i = 2; i < nums.length; i++) {
          if (nums[i] != nums[pos - 2]) {
              nums[pos++] = nums[i];
          }
      }
      return pos;
  }
}