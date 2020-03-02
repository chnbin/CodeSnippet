class Solution {
  public int[] smallerNumbersThanCurrent(int[] nums) {
      // Time complexity: O(n) where n is the length of nums.
      // Space complexity: O(n + c) where n is the length of nums and c is the range of number.
      int[] numsTable = new int[101];
      int[] res = new int[nums.length];
      
      // Count frequency of each of number
      for (int num: nums) {
          numsTable[num]++;
      }
      
      // Count prefix sum
      for (int i = 1; i < numsTable.length; i++) {
          numsTable[i] += numsTable[i-1];
      }
      
      for (int i = 0; i < nums.length; i++) {
          if (nums[i] == 0) { continue; }
          res[i] = numsTable[nums[i]-1];
      }
      
      return res;
  }
}