class Solution {
  public int missingNumber(int[] nums) {
      int sum = 0;
      int len = 0;
      for (int num: nums) { 
          sum += num;
          len++;
      }
      
      return (1 + len)*(len)/2 - sum;
  }
}