class Solution {
  public int firstMissingPositive(int[] nums) {
      // 由於本題有嚴重的條件限制，因此排序或是使用HashMap無法使用。
      // 在此使用Bucket的方式來解。
      // 以[1, 2, 0] 為例，這輸入長度為3，我們會希望
      // index 0, 1, 2 排成的值為：
      //      [1, 2, 0]
      // 因此第一個消失的正整數為3（注意0非正整數）。
      // 對於一個長度為4的陣列，我們會希望
      // index 0, 1, 2, 3 排成：
      //       1, 2, 3, 4 的樣子
      // 也就是index 0的地方應該是1，index 1的地方是2, ... , index i 的地方是 i + 1
      // 因此寫成程式的話應該是 nums[i] == nums[nums[i] - 1]
      
      // 以Example 1來說，nums[0] = 1 == nums[nums[0] - 1]為真，那就不用換
      // 若Example 3來說，nums[0] = 3 != nums[nums[0] - 1](-1)為假，那就把3, -1交換
      if (nums == null || nums.length == 0) { return 1; }
      
      for (int i = 0; i < nums.length; i++) {
          // 只處理nums[i] 的範圍在 1 ~ nums.length的數
          // 使用while是交換之後在index i的數字也許還不是符合nums[i] == nums[nums[i] - 1]
          // 的條件，因此要一直換一直換，直到條件成立。
          // 可以用[4, -1, 1, 3]來想
          while (nums[i] > 0 && nums[i] <= nums.length &&
              nums[i] != nums[nums[i] - 1]) {
              // 交換nums[i] 與 nums[nums[i] - 1]
              int tmp = nums[i];
              nums[i] = nums[tmp - 1];
              nums[tmp - 1] = tmp;
          }
      }
      
      // 遍歷nums，如果nums[i] != (i + 1)，則 i + 1就是答案
      for (int i = 0; i < nums.length; i++) {
          if (nums[i] != (i + 1)) { return i + 1; }
      }
      
      // 如果nums是排好序的狀態如：[1, 2, 3, 4, 5]，則陣列長度加上1為答案
      return nums.length + 1;
  }
}