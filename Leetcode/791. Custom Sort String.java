class Solution {
  public String customSortString(String S, String T) {
      // S = "cba"
      // T = "cabaccda"
      // 由於S為正確的順序，因此我們把T的字數做統計，以這個範例來說：
      // T 統計出來為a有3個，b有1個，c有3個，d有0個。
      // 之後依序把S的字元放入統計表看個數印出
      // cccbaaa
      // 然後再把出線個數為0者加到字串後面
      String res = "";
      
      Map<Character, Integer> map = new HashMap<>();
      
      for (char c: T.toCharArray()) {
          map.put(c, map.getOrDefault(c, 0) + 1);
      }
      
      for (char key: S.toCharArray()) {
          if (!map.containsKey(key)) { continue ;}
          int value = map.get(key);
          if (value >= 1) {
              while (value > 0) {
                  res += key;
                  value--;
              }
          }
          map.put(key, value);
      }
      
      for (char key: map.keySet()) {
          int value = map.get(key);
          if (value > 0) {
              while (value > 0) {
                  res += key;
                  value--;
              }
          }
      }
      
      return res;
  }
}