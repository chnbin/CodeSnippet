class Solution {
  /*
    對於隨意選出的兩個整數a與b，要讓ax+by = 1，其最大公因數應該為1。
    使用數學的語言來講：方程式 ax+by=1 有整數解若且唯若整數a和b互質
    而對於隨意選出的n個整數a1, a2, ..., an要讓a1x + a2y + ... + anz = 1，
    就是a1, a2, ..., an的最大公因數為1。
    這不用一對一對去算，只要一對為1就可以，因為：
    GCD(a1, a2, ..., an) = GCD(GCD(GCD(GCD(a1, a2),a3),a4)....an)
  */
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