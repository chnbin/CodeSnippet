class Solution {
  // This is a radix problem.
  // Just change decimal to 9-based.
  // return Integer.parseInt(Integer.toString(n, 9));
  public int newInteger(int n) {
      int ans = 0;
      int base = 1;

      while (n > 0) {
          ans += ((n % 9) * base);
          n /= 9;
          base *= 10;
      }
      
      return ans;
  }
}