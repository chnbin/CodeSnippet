class Solution {
  public boolean isMonotonic(int[] A) {
      boolean isInc = true;
      boolean isDec = true;
      
      for (int i = 1; i < A.length; i++) {
          isInc &= (A[i] >= A[i-1]);
          isDec &= (A[i] <= A[i-1]);
      }
      
      return (isInc | isDec);
  }
}