class Solution {
  public int peakIndexInMountainArray(int[] A) {
      int l = 0;
      int r = A.length - 1;
      
      while (l <= r) {
          int m = l + (r - l)/2;
          
          if ((A[m] > A[m+1]) && (A[m-1] < A[m])) {
              return m;
          } else if (A[m] < A[m+1]) {
              // peak is in right side
              l = m + 1;
          } else if ((A[m-1] > A[m])) {
              // peak is in left side
              r = m - 1;
          } else {
              // pass
          }
      }
      return -1;
  }
}