class Solution {
  public boolean canConstruct(String s, int k) {
      if (k > s.length()) { return false; }
      int[] table = new int[26];
      int odd = 0;
      
      for (char c: s.toCharArray()) {
          table[c - 'a']++;
      }
      
      for (int cnt: table) {
          if (cnt % 2 == 1) {
              odd++;
          }
      }
      
      if (odd > k) {
          return false;
      }
      return true;
  }
}
