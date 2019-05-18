class Solution {
  public String convertToTitle(int n) {
      StringBuilder res = new StringBuilder();
      
      while (n > 0) {
          if (n % 26 == 0) {
              res.append('Z');
              n -= 26;
          } else {
              res.append((char)((n % 26) - 1 + 'A'));
              n -= (n % 26) - 1;
          }
          n /= 26;
      }
      return res.reverse().toString();
  }
  // Get rid of if-else
  public String convertToTitle2(int n) {
    StringBuilder res = new StringBuilder();
    
    while (n > 0) {
        res.append((char)(--n % 26 + 'A'));
        n /= 26;
    }
    return res.reverse().toString();
}
}
