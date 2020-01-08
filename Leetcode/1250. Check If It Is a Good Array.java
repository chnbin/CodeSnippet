class Solution {
  public boolean isGoodArray(int[] nums) {
      if (nums.length == 1) {
          return (nums[0] == 1) ? true : false;
      }
      int gcd = findGCD(nums[0], nums[1]);
      
      for (int i = 2; i < nums.length; i++) {
          gcd = findGCD(nums[i], gcd);
      }
      
      return (gcd == 1);
  }
  
  private int findGCD(int m, int n) {
      if (m < n) {
          findGCD(n, m);
      }
      
      if (m % n == 0) {
          return n;
      }
      
      return findGCD(n, m % n);
  }
}