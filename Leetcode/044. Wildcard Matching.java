class Solution {
  public boolean isMatch(String s, String p) {
      int sp = 0; // Pointer of s
      int pp = 0; // Pointer of p
      int star = -1; // Record where is * now
      int match = 0; // Match sp index;
      
      while (sp < s.length()) {
          // 考慮以下幾種狀況：
          if (pp < p.length() && ((s.charAt(sp) == p.charAt(pp)) || p.charAt(pp) == '?') ) {
              // 1. 兩個字元相等或是p是?字元，這樣兩個都匹配，所以個往前加一
              pp++;
              sp++;
          } else if (pp < p.length() && p.charAt(pp) == '*') {
              // 2. 兩個字元不相等，但是p是*
              star = pp;
              match = sp;
              pp++;
          } else if (star != -1) {
              // 3. 目前有存在*
              pp = star + 1; // p指標停在star的下一個
              match++; // 因為有存在star，加上1 2狀況已經不符合，因此可以多往前相配一個
              sp = match;
          } else {
              // 4. 都不是
              return false;
          }
      }
      
      while (pp < p.length() && p.charAt(pp) == '*') {
          pp++;
      }
      return pp == p.length();
  }
}