class Solution {
  public int[] sortArrayByParityII(int[] A) {
      int idxEven = 0;
      int idxOdd = 1;
      
      while (idxEven < A.length && idxOdd < A.length) {
          if (A[idxEven] % 2 == 0) {
              idxEven += 2;
          } else {
              if (A[idxOdd] % 2 == 1) {
                  idxOdd += 2;
              } else {
                  swap(A, idxEven, idxOdd);
                  idxEven += 2;
              }
          }
      }
      return A;
  }
  
  private void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
  }
}