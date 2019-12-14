class Solution {
  private static int modulo = (int)Math.pow(10, 9.0) + 7;
  
  public int numPrimeArrangements(int n) {
      // 數字： 1 到 n 的數字有p個質數，因此非質數可以排列的位置共有(n - p)!的組合
      // index： 1 到 n 的數字有p個質數index，p個質數要放在p個位置上故有p!組合
      // 因此所有組合數量為(n - p)!*p!
      long res = 0;
      int p = 0;
      
      // 1. 算質數個數
      for (int i = 1; i <= n; i++) {
          if (isPrime(i)) { p++; }
      }

      res = factorial(p);
      res = (res *factorial(n - p) % modulo);
      return (int)res;
  }
  
  private boolean isPrime(int n) {
      if (n < 2) { return false; }
      if (n == 2) { return true; }
      if (n % 2 == 0) { return false; }
      
      for (int i = 2; i <= (int)Math.sqrt(n); i++) {
          if (n % i == 0) { return false; }
      }
      
      return true;
  }
  
  private long factorial(int n) {
      long res = 1;
      
      for (int i = 1; i <= n; i++) {
          res = ((res * i) % modulo);
      }
      
      return res;
  }
}