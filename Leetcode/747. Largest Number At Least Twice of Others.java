class Solution {
  public int dominantIndex(int[] nums) {
      /**
       * Find whether the largest element is at least twice as much as every other 
       * number in the array is equivalent to find whether the largest element is at least twice as much as 
       * second largest element in the array. Therefore we must find three things: the largest element, the
       * index of the largest element and the second largest element.
       * 
       * There are many methods to solve this problem.
       * 1. Comparison sort
       * To sort nums and then compare largest and 2nd largest elements. 
       * Time complexity is n(nlogn) or O(n^2), this depends on what comparison sort you use.
       * 
       * 2. non-comparison sort:
       * Time complexity is O(n).
       * 
       * 3. Traverse array once.
       */
      if (nums == null || nums.length == 0) { return 0; }
      int max = 0;
      int secondMax = 0;
      int index = -1;
      
      for (int i = 0; i < nums.length; i++) {
          if (nums[i] > max) {
              secondMax = max;
              max = nums[i];
              index = i;
          } else if (nums[i] > secondMax) {
              secondMax = nums[i];
          }
      }
      
      return (max >= (secondMax * 2)) ? index : -1;
  }
}