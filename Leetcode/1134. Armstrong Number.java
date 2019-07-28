class Solution {
  public boolean isArmstrong(int N) {
      int k = 0;
      int n = N;
      while (n > 0) {
          n /= 10;
          k++;
      }
      n = N;
      int res = 0;
      
      while (n > 0) {
          int d = n % 10;
          res += (int)Math.pow(d, k);
          n /= 10;
      }
      
      return res == N;
  }
  
  
}