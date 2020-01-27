class Solution {
  public int findPairs(int[] nums, int k) {
      if (nums == null || nums.length == 0 || k < 0) {
          return 0;
      }
      
      // To record the frequence of each num
      Map<Integer, Integer> map = new HashMap<>();
      int res = 0;
      
      for (int num: nums) {
          map.put(num, map.getOrDefault(num, 0) + 1);
      }
      
      for (int key: map.keySet()) {
          if (k == 0) {
              if (map.get(key) >= 2) {
                  res++;
              }
          } else {
              if (map.containsKey(key + k)) {
                  res++;
              }
          }
      }
      return res;
  }
}