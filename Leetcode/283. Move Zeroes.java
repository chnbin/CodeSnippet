class Solution {
  public void moveZeroes(int[] nums) {
      int pos = 0;

      for (int i = 0; i < nums.length; i++) {
          if (nums[i] != 0) {
              swap(nums, pos, i);
              pos++;
          }
      }
  }
  
  public void swap(int[] intArray, int left, int right) {
      int tmp = intArray[left];
      intArray[left] = intArray[right];
      intArray[right] = tmp;
  }
}