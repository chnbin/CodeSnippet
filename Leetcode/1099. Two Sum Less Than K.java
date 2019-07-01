import java.util.Arrays;

// TODO: Binary serach
class Solution {
  public int twoSumLessThanK(int[] A, int K) {
      int res = -1;
      Arrays.sort(A);
      int left = 0;
      int right = A.length - 1;
      
      while (left < right) {
          int sum = A[left] + A[right];
          
          if (sum > K) {
              right--;
          } else {
              if (sum != K) {
                  res = Math.max(res, sum);    
              }                
              left++;
          }
      }
      
      return res;
  }
}