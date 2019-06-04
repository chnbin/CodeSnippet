class Solution {
  public int integerBreak(int n) {
      if (n == 2) { return 1; }
      if (n == 3) { return 2; }
      int res = 1;
      /**
       * Find pattern,
       * n = 2 -> 1 * 1 = 1
       * n = 3 -> 1 * 2 = 2
       * n = 4 -> 2 * 2 = 4
       * n = 5 -> 2 * 3 = 6
       * n = 6 -> 3 * 3 = 9
       * n = 7 -> 3 * 4 = 12
       * n = 8 -> 3 * 3 * 2 = 18
       * n = 9 -> 3 * 3 * 3 = 27
       * n = 10 -> 3 * 3 * 4 = 36
       */
      while (n > 4) {
          res *= 3;
          n -= 3;
      }
      return res * n;
  }
}