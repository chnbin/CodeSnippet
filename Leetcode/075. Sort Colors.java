class Solution {
  public void sortColors(int[] nums) {
      if (nums == null || nums.length == 0) return;
      int index = 0; // index of 1
      int left = 0; // index of 0
      int right = nums.length - 1; // index of 2
      
      while (index <= right) {
          if (nums[index] == 1) {
              index++;
          } else if (nums[index] == 0) {
              // 如果是1的話，就把index與left交換(0 1交換)
              // 然後index與left各前進1
              swap(nums, index++, left++);
          } else {
              // 如果遇到2，就把index與right交換(0 2交換)
              // 然後right退一格
              // index不前進，因為如果nums[index] = 2
              // nums[right] = 0
              // 之後還得判斷一次
              swap(nums, index, right--);
          }
      }
  }
  
  public void swap(int[] nums, int left, int right) {
      int temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
  }
}