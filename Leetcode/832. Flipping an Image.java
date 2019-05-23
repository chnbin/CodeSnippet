class Solution {
  public int[][] flipAndInvertImage(int[][] A) {
      /**
       * Using two pointer row by row.
       * For example:
       * 1,0,1,0,0
       * ^       ^   swap row[left] and row[right] and then change row[left] and row[right] from 0 to 1 and vise versa.
       * If left is equal to right, flip once is enough.
       */
      if (A[0].length == 0) return new int[0][0];
      int m = A.length;
      int n = A[0].length;
      
      for (int i = 0; i < m; i++) {
          int left = 0;
          int right = n - 1;
          
          while (left <= right) {
              swap(A[i], left, right);
              A[i][left] ^= 1;
              if (left != right) { A[i][right] ^= 1; }
              left++;
              right--;
          }
      }
      return A;
  }
  
  public void swap(int[] arr, int i, int j) {
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
  }
}