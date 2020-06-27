class Solution {
  public int longestSubarray(int[] nums) {
      if (nums == null || nums.length == 0) {
          return 0;
      }
      List<Integer> l = new ArrayList<>();
      int cnt = 0;
      int oneC = 0;
      int oneZ = 0;
      
      for (int i = 0; i < nums.length; i++) {
          if (nums[i] == 0) {
              if (cnt > 0) {
                  l.add(cnt);
                  cnt = 0;
              }
              l.add(0);
              oneZ++;
          } else {
              oneC++;
              cnt++;
          }
      }
      
      if (cnt > 0) {
          l.add(cnt);
      }
      
      if (oneC == nums.length) {
          return oneC - 1;
      }
      
      if (oneZ == nums.length) {
          return 0;
      }
      
      int res = 0;
      
      for (int i = 0; i < l.size(); i++) {
          int total = 0;
          if (l.get(i) == 0) {
              if (i - 1 >= 0 && i - 1 < l.size()) {
                  total += l.get(i - 1);
              }
              if (i + 1 >= 0 && i + 1 < l.size()) {
                  total += l.get(i + 1);
              }
              res = Math.max(res, total);
          }
      }
      
      return res;
  }
}
