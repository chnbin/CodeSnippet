class Solution {
  /*
    Time complexity: O(n) where n is the length of nums.
    Index[i] is the i-th element of index, we check all elements j where 0 <= j < i (elements before index[i]),
    If index[j] is equal or bigger than index[i], this means if we insert element in index[i] will let index[j] move to next
    position so index[j] should added by 1.
   */
  public int[] createTargetArray(int[] nums, int[] index) {
      int[] res = new int[nums.length];
      
      for (int i = 1; i < nums.length; i++) {
          for (int j = 0; j < i; j++) {
              if (index[j] >= index[i]) {
                  index[j]++;
              }
          }
      }
      
      for (int i = 0; i < nums.length; i++) {
          res[index[i]] = nums[i];
      }
      
      return res;
  }
}
