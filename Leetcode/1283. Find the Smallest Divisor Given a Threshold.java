class Solution {
  public int smallestDivisor(int[] nums, int threshold) {
      int left = 1;
      int right = 1000001;
      
      // divisor 用 left 一定是大於 right
      while (left <= right) {
          int mid = left + (right - left) / 2;
          
          if (divisionSum(nums, mid) > threshold) {
              // 如果算出來的值比threshold大，表示選擇的divior太大
              left = mid + 1;
          } else {
              right = mid - 1;
          }
      }
      
      return left;
  }
  
  private int divisionSum(int[] nums, int divisor) {
      int division = 0;
      for (int num : nums) {
        division += (num + divisor - 1) / divisor;
      }
      return division;
  }
}