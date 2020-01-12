class Solution {
  public int[] getNoZeroIntegers(int n) {
      int[] res = new int[2];
      
      for (int i = 1; i < n; i++) {
          int A = n - i;
          int B = n - A;
          if (!isContaionsZero(A) && !isContaionsZero(B)) {
              res[0] = A;
              res[1] = B;
              return res;
          }
      }
      
      return res;
  }
  
  private boolean isContaionsZero(int num) {
      while (num > 0) {
          if (num % 10 == 0) {
              return true;
          }
          num /= 10;
      }
      return false;
  }
}