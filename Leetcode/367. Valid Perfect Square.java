// Use long to avoid 2147483647 case.
class Solution {
  public boolean isPerfectSquare(int num) {
      long l = 1;
      long r = num;
      
      while (l <= r) {
          long m = l + (r - l) / 2;
          
          if (m*m == num) {
              return true;
          } else if (m*m > num) {
              r = (int)(m - 1);
          } else {
              l = (int)(m + 1);
          }
      }
      return false;
  }
}