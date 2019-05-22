class Solution {
  public int bitwiseComplement(int N) {
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