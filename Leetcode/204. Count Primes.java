class Solution {
  public int countPrimes(int n) {
      if (n <= 2) { return 0; }
      int res = 1;
      boolean[] notPrimes = new boolean[n+1];
      
      // sieve of eratosthenes
      for (int i = 2; i <= (int)Math.sqrt(n); i+=1) {
          if (!notPrimes[i]) {
              for (int j = i*i; j <= n; j += i) {
                  notPrimes[j] = true;
              }
          }
      }
      
      for (int i = 3; i < n; i++) { 
          if (!notPrimes[i]) {
              res++;
          }
      }
      return res;
  }
}