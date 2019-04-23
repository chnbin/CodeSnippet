class Solution278  {
  public boolean isBadVersion(int n) { return true; }
  public int firstBadVersion(int n) {
      int l = 1;
      int r = n;
      
      while (l <= r) {
          int m = l + (r - l) / 2;
          
          if (isBadVersion(m)) {
              r= m - 1;
          } else {
              l = m + 1;
          }
      }
      
      return l;
  }
}