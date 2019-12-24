class Solution {
  public int numSubarrayProductLessThanK(int[] nums, int k) {
      if (k == 0) { return 0; }
      
      int res = 0;
      int begin = 0, end = 0, currProd = 1, count = 1;
      int n = nums.length;
      
      while (end < n) {
          currProd *= nums[end];
          end++;
          
          while (begin < n && currProd >= k) {
              currProd /= nums[begin];
              begin++;
          }
          
          res += (end - begin);
      }
      
      return (res > 0) ? res : 0;
  }
}