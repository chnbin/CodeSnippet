class Solution {
  public boolean isPossibleDivide(int[] nums, int k) {
      if (nums.length == 0 || k == 0) { return true; }
      if (nums.length % k != 0) { return false; }
      
      // 使用TreeMap
      TreeMap<Integer, Integer> map = new TreeMap<>();
      
      for (int i = 0; i < nums.length; i++) {
          map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
      }
      
      while (!map.isEmpty()) {
          for (int key = map.firstKey(), j = 0; j < k; key++, j++) {
              if (!map.containsKey(key)) {
                  return false;
              }
              map.put(key, map.get(key) - 1);
              if (map.get(key) == 0) {
                  map.remove(key);
              }
          }
      }
      return true;
  }
}