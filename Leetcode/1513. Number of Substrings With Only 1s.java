class Solution {
  private static final int MOD = (int)1e9 + 7;
  public int numSub(String s) {
      int res = 0;
      int cnt = 0;
      int pos = 0;
      for (char c: s.toCharArray()) {
          if (c == '0') {
              res += (cnt % MOD);
              res = res % MOD;
              cnt = 0;
              pos = 0;
          } else {
              pos++;
              cnt += (pos % MOD);
              cnt = cnt % MOD;
          }
      }
      
      if (cnt != 0) { res += (cnt % MOD); }
      
      return res % MOD;
  }
}
