class Solution {
  private long MOD = (long)1e9 + 7;
  public int numOfWays(int n) {
      long curr121 = 6;
      long curr123 = 6;
      
      for (int i = 1; i < n; i++) {
          long next121 = curr121 * 3 + curr123 * 2;
          long next123 = curr121 * 2 + curr123 * 2;
          curr121 = (next121 % MOD);
          curr123 = (next123 % MOD);
      }
      
      return (int)((curr121 + curr123) % MOD);
  }
}
