class Solution {
  // Time complexity: O(N)
  // Space complexity: O(N)
  public String generateTheString(int n) {
      if (n % 2 == 1) {
          return generateStringByTimes('a', n);
      }
      
      return generateStringByTimes('a', 1) + generateStringByTimes('b', n - 1);
  }
  
  private String generateStringByTimes(char c, int times) {
      StringBuilder res = new StringBuilder();
      
      for (int i = 0; i < times; i++) {
          res.append(c);
      }
      
      return res.toString();
  }
}