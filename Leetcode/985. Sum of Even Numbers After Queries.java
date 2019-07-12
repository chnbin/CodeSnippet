class Solution {
  public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
      int[] res = new int[queries.length];
      boolean[] isEven = new boolean[queries.length];
      int evenSum = 0;
      
      for (int i = 0; i < A.length; i++) {
          if (A[i] % 2 == 0) {
              evenSum += A[i];
              isEven[i] = true;
          }
      }
      
      for (int i = 0; i < queries.length; i++) {
          int index = queries[i][1];
          int diff = queries[i][0];
          
          if (isEven[index]) {
              if (diff % 2 == 0) {
                  evenSum += diff;
                  A[index] += diff;
              } else {
                  evenSum -= A[index];
                  A[index] += diff;
                  isEven[index] = false;
              }
          } else {
              if (diff % 2 == 0) {
                  A[index] += diff;
              } else {
                  evenSum += (diff + A[index]);
                  A[index] += diff;
                  isEven[index] = true;
              }
          }
          res[i] = evenSum;
      }
      return res;
  }
}