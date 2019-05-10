class Solution {
  public int[] sortArrayByParity(int[] A) {
      int pos = 0;
      
      for (int i = 0; i < A.length; i++) {
          if (A[i] % 2 == 0) {
              swap(A, i, pos);
              pos++;
          }
      }
      return A;
  }
  
  public void swap(int[] arr, int x, int y) {
      int tmp = arr[x];
      arr[x] = arr[y];
      arr[y] = tmp;
  }
}