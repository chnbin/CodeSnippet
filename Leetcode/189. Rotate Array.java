class Solution {
  public void rotate(int[] nums, int k) {
      k %= nums.length;
      reverse(nums, 0, nums.length - 1);
      reverse(nums, 0, k - 1);
      reverse(nums, k, nums.length - 1);
  }
  
  public void reverse(int[] nums, int left, int right) {
      while (left < right) {
          swap(nums, left, right);
          left++;
          right--;
      }
  }
  
  public void swap(int[] intArray, int left, int right) {
    int tmp = intArray[left];
    intArray[left] = intArray[right];
    intArray[right] = tmp;
  }
}