class Solution {
  public int minDominoRotations(int[] A, int[] B) {
      int length = A.length;
      int pos = 0;
      int aSwap = 0;
      int bSwap = 0;
      
      while (pos < length && ((A[pos] == A[0]) || (B[pos] == A[0]))) {
          if (A[pos] != A[0]) {
              aSwap++;
          }
          if (B[pos] != A[0]) {
              bSwap++;
          }
          pos++;
      }
      
      if (pos == length) {
          return Math.min(aSwap, bSwap);
      }
      
      pos = 0;
      aSwap = 0;
      bSwap = 0;
      
      while (pos < length && ((A[pos] == B[0]) || (B[pos] == B[0]))) {
          if (A[pos] != B[0]) {
              aSwap++;
          }
          if (B[pos] != B[0]) {
              bSwap++;
          }
          pos++;
      }
      
      if (pos == length) {
          return Math.min(aSwap, bSwap);
      }
             
      return -1;   
  }
}