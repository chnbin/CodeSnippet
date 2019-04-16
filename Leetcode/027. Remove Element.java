class Solution {
  public int removeElement(int[] nums, int val) {
     int pos = 0;
      for (int i = 0; i < nums.length; i++) {
          if (nums[i] != val) {
              swap(nums, pos, i);
              pos++;
          }
      }
      return pos;
  }
  
  public void swap(int[] intArray, int left, int right) {
      int tmp = intArray[left];
      intArray[left] = intArray[right];
      intArray[right] = tmp;
  }
}