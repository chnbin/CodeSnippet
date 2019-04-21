class Solution {
  public int reverse(int x) {
      // Corner case
      // -2147483648 ~ 2147483647
      long ans = 0;
      while (x != 0) {
          ans *= 10;
          ans += (x % 10);
          x /= 10;
          if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return 0;
      }
      return (int)ans;
  }
}