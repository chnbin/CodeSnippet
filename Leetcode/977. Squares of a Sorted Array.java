class Solution {
  public int[] sortedSquares(int[] A) {
      int left = 0;
      int right = A.length - 1;
      int[] ans = new int[A.length];
      int pos = A.length - 1;
      
      while (left <= right) {
          if (Math.abs(A[left]) > Math.abs(A[right])) {
              ans[pos] = A[left] * A[left];
              left++;
              pos--;
          } else {
              ans[pos] = A[right] * A[right];
              right--;
              pos--;
          }
      }
      return ans;
  }
}