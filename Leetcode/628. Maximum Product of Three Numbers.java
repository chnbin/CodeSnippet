import java.util.Arrays;

class Solution {
  // Code is simpler but slower
  public int maximumProduct1(int[] nums) {
    if (nums.length < 3) { return 0; }
    int len = nums.length - 1;
    Arrays.sort(nums);
    return Math.max(nums[len] * nums[len - 1] * nums[len - 2],
                    nums[len] * nums[0] * nums[1]);
  }

  // Faster
  public int maximumProduct(int[] nums) {
      if (nums.length < 3) { return 0; }
      
      int first = Integer.MIN_VALUE;
      int second = Integer.MIN_VALUE;
      int third = Integer.MIN_VALUE;
      int lastOne = Integer.MAX_VALUE;
      int lastTwo = Integer.MAX_VALUE;
      
      for (int num: nums) {
          if (num > first) {
              third = second;
              second = first;
              first = num;
          } else if (num >= second) {
              third = second;
              second = num;
          } else if (num >= third) {
              third = num;
          }
          
          if (num < lastOne) {
              lastTwo = lastOne;
              lastOne = num;
          } else if (num <= lastTwo) {
              lastTwo = num;
          }
      }
      
      return Math.max(first * second * third, lastOne * lastTwo * first);
  }
}