class Solution {
  public boolean validMountainArray(int[] A) {
      if (A.length < 3) { return false; }
      int pos = 1;
      int len = A.length;
      boolean isUp = false;
      boolean isDown = false;
      while (pos < len) {
          if (A[pos] > A[pos-1]) {
              pos++;
              isUp = true;
          } else {
              break;
          }
      }
      
      while (pos < len) {
          if (A[pos] < A[pos-1]) {
              pos++;
              isDown = true;
          } else {
              break;
          }
      }
      
      return (pos == len) && (isUp && isDown);
  }
}