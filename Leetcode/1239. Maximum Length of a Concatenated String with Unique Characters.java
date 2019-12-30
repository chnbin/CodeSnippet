class Solution {
  public int maxLength(List<String> arr) {
      if (arr == null || arr.size() == 0) { return 0; }
      Map<Integer, List<String>> map = new HashMap<>();
      dfs(arr, map, 0, arr.size(), "");
      
      int maxLen = 0;
      
      for (int key: map.keySet()) {
          maxLen = Math.max(maxLen, key);
      }
      
      return maxLen;
  }
  
  private void dfs(List<String> arr, Map<Integer, List<String>> map, int start, int end, String currStr) {
      if (start == end) {
          return;
      }
      
      for (int i = start; i < end; i++) {
          String tmp = currStr;
          currStr += arr.get(i);
          
          if (isUnique(currStr)) {
              // System.out.println(currStr);
              if (map.containsKey(currStr.length())) {
                  map.get(currStr.length()).add(currStr);
              } else {
                  map.put(currStr.length(), new ArrayList<String>());
                  map.get(currStr.length()).add(currStr);
              }
          }
          dfs(arr, map, i + 1, end, currStr);
          currStr = tmp;
      }
  }
  
  private boolean isUnique(String str) {
      int[] chars = new int[26];
      
      for (char c: str.toCharArray()) {
          if (chars[c - 'a'] == 0) {
              chars[c - 'a']++;
          } else {
              return false;
          }
      }
      
      return true;
  }
}