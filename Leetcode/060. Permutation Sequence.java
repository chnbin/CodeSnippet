class Solution {
  public String getPermutation(int n, int k) {
      int[] nums = new int[n];
      
      for (int i = 0; i < n; i++) {
          nums[i] = i + 1;
      }
      
      while (k - 1 > 0) {
          nextPermutation(nums);
          k--;
      }
      
      StringBuilder sb = new StringBuilder();
      
      for (int i = 0; i < n; i++) {
          sb.append(nums[i]);
      }
      
      return sb.toString();
  }
  
  public void nextPermutation(int[] nums) {
      int n = nums.length;
      int pos = 0;
      
      for (int i = n - 2; i >= 0; i--) {
          if (nums[i] < nums[i+1]) {
              // i是第一個降續的位置
              for (int j = n - 1; j > i; j--) {
                  if (nums[j] > nums[i]) {
                      pos = j;
                      break;
                  }
              }
              
              swap(i, pos, nums);
              reverseArray(i+1, n - 1, nums);
              return;
          }
      }
      reverseArray(0, n - 1, nums);
  }
  
  private void reverseArray(int start, int end, int[] nums) {
      while (start < end) {
          swap(start, end, nums);
          start++;
          end--;
      }
  }
  
  private void swap(int i, int j, int[] nums) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
  }
}
