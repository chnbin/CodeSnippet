class Solution {
  public List<String> simplifiedFractions(int n) {
      List<String> res = new ArrayList<>();
     
      for (int i = 2; i <= n; i++) {
          for (int j = 1; j <= i - 1; j++) {
              int gcd = findGCD(i, j);
              String candicate = "";
              
              if (gcd == 1) {
                  candicate = j + "/" + i;
                  res.add(candicate);
              }
          }
      }
      
      return res;
  }
  
  private int findGCD(int m, int n) {
      if (m < n) {
          return findGCD(n, m);
      }
      
      if (m % n == 0) { return n; }
      
      return findGCD(n, m % n);
  }
}
