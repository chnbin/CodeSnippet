import java.util.Arrays;

class Solution {
  public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
      int[] res = new int[nums.length];
      int left = 0;
      int right = nums.length - 1;
      int pos = 0;
      
      while (left <= right) {
          int r1 = computeFormula(nums[left], a, b, c);
          int r2 = computeFormula(nums[right], a, b, c);
          
          if (a > 0) {
              res[pos] = Math.max(r1, r2);
              if (r1 > r2) {
                  left++;
              } else {
                  right--;
              }
          } else {
              res[pos] = Math.min(r1, r2);
              if(r1 < r2) {
                  left++;
              } else {
                  right--;
              }
          }
          pos++;
      }
      if (a > 0) { Arrays.sort(res); }
      return res;
  }
  
  private int computeFormula(int x, int a, int b, int c) {
      return a*x*x + b*x + c;
  }
}