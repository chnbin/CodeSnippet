class Solution {
  public int bitwiseComplement(int N) {
      /**
       * Elegant way to change 0 to 1 and vice versa.
       * 1. Subtraction
       * i = 1 - i
       * 
       * 2. XOR the value with 1.
       * 1 ^ 1 = 0;
       * 0 ^ 0 = 1;
       * Method 2 can flip true <--> false either way.
       */
      if (N == 0) { return 1; }
      if (N == 1) { return 0; }
      int res = 0;
      double base = 1;
      int i = 1;
      while (N > 0) {
          res += (((N & 1)^1) * base);
          base = Math.pow(2, i);
          N = N >>> 1;
          i++;
      }
      return res;
  }
}