class Solution {
  public int minFlips(int a, int b, int c) {
      int res = 0;
      
      while (a > 0 || b > 0 || c > 0) {
          int A = a & 1;
          int B = b & 1;
          int C = c & 1;
          
          a = a >>> 1;
          b = b >>> 1;
          c = c >>> 1;
          
          if (((A|B) == 0) && C == 1) {
              res += 1;
              continue;
          }
          
          if (((A&B) == 1) && C == 0) {
              res += 2;
              continue;
          }
          
          if (((A|B) == 1) && C == 0) {
              res += 1;
              continue;
          }
      }
      
      return res;
  }
}
