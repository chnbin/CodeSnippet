class Solution {
  public int findShortestSubArray(int[] nums) {
      int[] numTable = new int[50000];
      int[] left = new int[50000];
      int[] right = new int[50000];
      
      int freq = 0;
      int res = Integer.MAX_VALUE;
      
      for (int i = 0; i < nums.length; i++) {
          if (numTable[nums[i]] == 0) {
              left[nums[i]] = i;
              right[nums[i]] = i;
          } else {
              right[nums[i]] = i;
          }
          numTable[nums[i]]++;
          freq = Math.max(freq, numTable[nums[i]]);
      }
      
      for (int i = 0; i < numTable.length; i++) {
          if (numTable[i] == freq) {
              res = Math.min(res, right[i] - left[i] + 1);
          }
      }
      return res;
  }
}