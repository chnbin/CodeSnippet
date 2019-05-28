class Solution {
  public boolean isPowerOfThree(int n) {
      if (n < 1) { return false;}
      
      while (n > 1) {
          if (n % 3 != 0) {
              return false;
          }
          n /= 3;
      }
      return n == 1;
  }

  public boolean isPowerOfThree2(int n) {
    /**
     *  Follow up: Could you do it without using any loop / recursion?
     *  Senior high school math: change of base.
     *  To check if log10(n)/Math.log10(3) is a postive integer, I think log(n)/log(3) words too.
     *  And this code shows how to check if a number is a type of integer elegantly.
     */
    if (n <= 0) { return false;}
    
    double m = Math.log10(n)/Math.log10(3);
    return m == (int)m;
  }

  public boolean isPowerOfThree3(int n) {
    /**
     * Follow up. A very smart way. Beacuse 3^19 < 2^31 < 3^20.
     * So we check if 3^19 module n is zero.
     */
    if (n < 1) { return false;}
    
    return (Math.pow(3, 19) % n) == 0;
  }
}