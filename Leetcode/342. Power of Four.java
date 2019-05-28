class Solution {
  public boolean isPowerOfFour(int num) {
      if (num <= 0) { return false; }
      
      while (num > 1) {
          if (num % 4 != 0) {
              return false;
          }
          num /= 4;
      }
      return num == 1;
  }

  public boolean isPowerOfFour1(int num) {
    if (num <= 0) { return false; }
    
    double m = Math.log10(num)/Math.log10(4);
    return m == (int)m;
  }
}