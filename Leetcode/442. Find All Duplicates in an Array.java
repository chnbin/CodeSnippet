/*
  這題其實限制很多，不然沒有辦法不用額外的空間且在O(n)時間複雜度內完成。
  這是把原來的陣列當成表格紀錄的題目。
 */
class Solution {
  public List<Integer> findDuplicates(int[] nums) {
      List<Integer> res = new ArrayList<>();
      
      // 因為元素的範圍就是1到n(陣列長)。
      // 我們把提供的陣列當成Hash Table，遇到7就把index 7 - 1取負。
      // 當我們走訪到一個元素，但是他是負數，代表他之前已經被拜訪過，因此為答案之一。
      for (int i = 0; i < nums.length; i++) {
          int idx = Math.abs(nums[i]) - 1;
          if (nums[idx] < 0) { res.add(idx + 1); }
          nums[idx] = -nums[idx];
      }
      
      return res;
  }
}