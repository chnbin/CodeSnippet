class Solution {
  public int numIdenticalPairs(int[] nums) {
      int res = 0;
      int n = nums.length;
      int[] table = new int[101];
      
      for (int i = 0; i < n; i++) {
          res += table[nums[i]];
          table[nums[i]]++;
      }
      
      return res;
  }
}
