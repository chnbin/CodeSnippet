class Solution {
  public double myPow(double x, int n) {
      if (n >= 0) {
          return myPowHelper(x, n);
      } else {
          return 1.0 / myPowHelper(x, n);
      }
  }
  
  // 5 ^ 7 = (5^3 * 5^3 * 5^1) = (5^1*5^1*5^1 + 5^1*5^1*5^1 + 5)
  private double myPowHelper(double x, int n) {
      if (n == 0) { return 1; }
      double y = myPowHelper(x, n /2);
      if (n % 2 == 0) {
          return y * y;
      } else {
          return y * y * x;
      }
  }
}