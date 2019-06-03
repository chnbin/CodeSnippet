class Solution {
  public boolean canThreePartsEqualSum(int[] A) {
      if (sumOfArray(A) % 3 != 0) {
          return false;
      }
      int target = sumOfArray(A) / 3;
      int prefixSum = 0;
      int parts = 0;
      
      for (int num: A) {
          prefixSum += num;
          if (prefixSum == target) {
              parts += 1;
              prefixSum = 0;
          }
      }
      
      return parts == 3;
  }
  
  private int sumOfArray(int[] nums) {
      int res = 0;
      for (int num: nums) {
          res += num;
      }
      return res;
  }
}