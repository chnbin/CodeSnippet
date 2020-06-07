class Solution {
  public int[] shuffle(int[] nums, int n) {
      int[] res = new int[2*n];
      int pos = 0;
      for (int i = 0; i < n; i++) {
          res[pos] = nums[i];
          res[pos+1] = nums[i + n];
          pos += 2;
      }
      return res;
  }
}
