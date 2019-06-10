class Solution {
  public int smallestRangeI(int[] A, int K) {
      if (A == null || A.length <= 1) { return 0; }
      int max = findMax(A);
      int min = findMin(A);
      return ((max - min) > 2*K) ? (max - K) - (min + K) : 0;
  }
  
  private int findMax(int[] nums) {
      int res = Integer.MIN_VALUE;
      
      for (int num: nums) {
          res = Math.max(res, num);
      }
      return res;
  }
  
  private int findMin(int[] nums) {
      int res = Integer.MAX_VALUE;
      
      for (int num: nums) {
          res = Math.min(res, num);
      }
      return res;
  }
}