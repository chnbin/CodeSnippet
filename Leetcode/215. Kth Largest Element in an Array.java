class Solution {
  public int findKthLargest(int[] nums, int k) {
      return helper(nums, 0, nums.length-1, k);
  }
  
  private int helper(int[] nums, int start, int end, int k) {
      while (true) {
          int pivot = partition(nums, start, end);

          if (pivot == k - 1) {
              return nums[pivot];
          } else if (pivot < k -1) {
              start = pivot + 1;
          } else {
              end = pivot-1;
          }
      }
      
  }

  private int partition(int[] nums, int start, int end) {
      int pos = start - 1;
      int pivot = nums[end];
      
      for (int i = start; i < end ; i++) {
          if (pivot < nums[i]) {
              pos++;
              swap(nums, i, pos);
          }
      }
      pos++;
      swap(nums, end, pos);
      return pos;
  }
  
  private void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
  }
}