class Solution {
  public int countPrimeSetBits(int L, int R) {
      int res = 0;
      
      for (int i = L; i <= R; i++) {
          int count = 0;
          int n = i;
          while (n != 0) {
              if ((n & 1) == 1) {
                  count++;
              }
              n = n >>> 1;
          }
          if (isPrime(count)) { res++; }
      }
      return res;
  }
  
  private boolean isPrime(int x) {
      // The max value of x is 10^6, 20 bits can contains x.
      if (x == 2 || x == 3 || x == 5 || x ==7 || x == 11
          || x == 13 || x == 17 || x == 19) {
          return true;
      }
      return false;
  }
}