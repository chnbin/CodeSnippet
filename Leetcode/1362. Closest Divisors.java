class Solution {
  // Time Complexity: O(sqrt(num))
  // Space Complexity: O(c)
  
  public int[] closestDivisors(int num) {
      int d1 = largestDivisor(num + 1);
      int d2 = largestDivisor(num + 2);
      
      if (Math.abs(d1 - (num + 1)/d1) > Math.abs(d2 - (num + 2)/d2)) {
          return new int[]{d2, (num + 2)/d2};
      }
      
      return new int[]{d1, (num + 1)/d1};
  }
  
  private int largestDivisor(int num) {
      int d = (int)Math.sqrt(num * 1.0);
      
      while (num % d != 0) {
          d--;
      }
      return d;
  }
}