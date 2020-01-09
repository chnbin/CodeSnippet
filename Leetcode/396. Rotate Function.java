class Solution {
  public int maxRotateFunction(int[] A) {
      /*
          F(0) = 0A + 1B + 2C +3D
          F(1) = 0D + 1A + 2B +3C
          F(2) = 0C + 1D + 2A +3B
          F(3) = 0B + 1C + 2D +3A
          試試看...
          F(1) - F(0) = 1A + 1B + 1C - 3D
          F(1) - F(0) + 4D = 1A + 1B + 1C + 1D, Let 1A + 1B + 1C + 1D = sum
          F(1) = sum + F(0) - 4D
          F(2) = sum + F(1) - 4C
          F(3) = sum + F(2) - 4B
          F(4) = sum + F(3) - 4A
      */
      int res = 0;
      int sum = 0;
      int f = 0;
      int n = A.length;
      
      for (int i = 0; i < n; i++) {
          f += (i * A[i]);
          sum += A[i];
      }
      
      res = f;
      
      for (int i = 1; i < n; i++) {
          f = sum + f - n * A[n - i];
          res = Math.max(res, f);
      }
      
      return res;
  }
}