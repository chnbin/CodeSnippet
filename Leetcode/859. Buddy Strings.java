class Solution {
  public boolean buddyStrings(String A, String B) {
      int[] charsA = new int[26];
      int[] charsB = new int[26];
      Set<Character> set = new HashSet<>();
      int cnt = 0;
      
      // 先看兩個字串組成是否相同
      for (char c: A.toCharArray()) {
          charsA[c - 'a']++;
          set.add(c);
      }
      
      for (char c: B.toCharArray()) {
          charsB[c - 'a']++;
      }
      
      for (int i = 0; i < 26; i++) {
          if (charsA[i] != charsB[i]) {
              return false;
          }
      }
      
      // 組成相同，檢查是否有錯位
      for (int i = 0; i < A.length(); i++) {
          if (A.charAt(i) != B.charAt(i)) {
              cnt++;
              if (cnt > 2) {
                  return false;
              }
          }
      }
      
      // 沒有錯位則要看能不能交換，abc這種就不能換（所有字元都相異），aaaaab這種就可以換
      if (cnt == 0) {
          return set.size() != A.length();
      }
      return cnt == 2;
  }
}
