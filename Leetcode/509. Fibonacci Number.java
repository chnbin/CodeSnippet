class Solution {
  public int fib(int N) {
      if (N == 1) { return 1; };
      if (N == 2) { return 1; };
      int ans = 0;
      int first = 1;
      int second = 1;
      
      for (int i = 2; i < N; i++) {
          ans = first + second;
          first = second;
          second = ans;
      }
      
      return ans;
  }
}