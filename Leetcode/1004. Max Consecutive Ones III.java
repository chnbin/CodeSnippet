class Solution {
  public int longestOnes(int[] A, int K) {
      int start = 0;
      int end = 0;
      int countZero = 0;
      int maxLen = 0;
      
      while (end < A.length) {
          if (A[end] == 0) {
              countZero++;
          }
          
          while (countZero > K) {
              if (A[start] == 0) {
                  countZero--;
              }
              start++;
          }
          maxLen = Math.max(maxLen, end - start + 1);
          end++;
      }
      return maxLen;
  }
}