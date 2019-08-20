class Solution {
  public String baseNeg2(int N) {
      if (N == 0) { return "0"; }
      /*
        作法與2的補數是相同的，但是用-2來取模有可能會出現負數，因此我們得阻止複數出現。
        若a/b的商是c且餘數是d，我們可以得知a = bc + d
        故d = a - bc 我們要確保d為正。
        假設b = -r
        上面的式子可以寫為
        d = a + rc
        a = -rc + d
        a = -rc + d + r -r
        a = -r(c+1) + (d + r)
        因此遇到負數的d時， 商加上1, d + r (r 的話 這裡是2)
      */
      String res = "";
      
      while (N != 0) {
          int d = N % (-2);
          N = (N / -2);
          if (d < 0) {
              N += 1;
              d += 2;
          }
          res = d + res;
      }
      
      return res;
  }
}