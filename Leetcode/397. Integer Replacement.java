class Solution {
  private int min = Integer.MAX_VALUE;
  
  public int integerReplacement(int n) {
      if (n < 1) { return -1; }
      helper(n, 0);
      return min;
  }
  
  private void helper(long n, int level) {
      if (n < 1) { return; }
      if (n == 1) {
          min = Math.min(min, level); 
          return;
      }
      
      if (n % 2 == 0) {
          helper(n/2, level+1);
      } else {
          helper(n+1, level+1);
          helper(n-1, level+1);
      }
  }
}