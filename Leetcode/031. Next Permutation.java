class Solution {
  public void nextPermutation(int[] nums) {
      // 1 2 7 4 3 1 的下一個是1 3 1 2 4 7
      // 這由最後面找過來，遇到第一個降序時記錄下位置，這邊遇到第一個降序是2, index 為 1
      // 再由最後一個往前找，第一個大於2的index是5, 值為3
      // 交換index 1, 5的值
      // 1 3 7 4 2 1
      // 然後把index 2到尾的值reverse
      // 1 3 1 2 4 7
      int n = nums.length;
      int pos = 0;
      
      for (int i = n - 2; i >= 0; i--) {
          if (nums[i] < nums[i+1]) {
              // i是第一個降續的位置
              for (int j = n - 1; j > i; j--) {
                  if (nums[j] > nums[i]) {
                      pos = j;
                      break;
                  }
              }
              
              swap(i, pos, nums);
              reverseArray(i+1, n - 1, nums);
              return;
          }
      }
      reverseArray(0, n - 1, nums);
  }
  
  private void reverseArray(int start, int end, int[] nums) {
      while (start < end) {
          swap(start, end, nums);
          start++;
          end--;
      }
  }
  
  private void swap(int i, int j, int[] nums) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
  }
}