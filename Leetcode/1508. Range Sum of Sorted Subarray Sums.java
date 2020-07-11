class Solution {
  public int rangeSum(int[] nums, int n, int left, int right) {
      int res = 0;
      int[] prefix = new int[n];
      List<Integer> set = new ArrayList<>();

      prefix[0] = nums[0];
      
      for (int i = 1; i < n; i++) {
          prefix[i] = nums[i] + prefix[i-1];
      }

      set.add(prefix[n - 1]);
      
      for (int i = 0; i < n - 1; i++) {
          set.add(prefix[i]);
          for (int j = i + 1; j < n; j++) {
              set.add(prefix[j] - prefix[i]);
          }
      }

      Collections.sort(set);
      
      for (int i = left - 1; i < right; i++) {
          res += set.get(i);
      }
      
      return res;
  }
}
