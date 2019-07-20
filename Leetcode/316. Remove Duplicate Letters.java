class Solution {
  public String removeDuplicateLetters(String s) {
      int[] count = new int[26];
      boolean[] used = new boolean[26];
      StringBuilder res = new StringBuilder();
      
      char[] str = s.toCharArray();
      
      for (char c: str) {
          count[c-'a']++;
      }
      
      for (char c: str) {
          count[c-'a']--;
          if (used[c-'a']) { continue; }
          
          while (res.length() > 0 && res.charAt(res.length()-1) > c && count[res.charAt(res.length()-1) - 'a'] > 0) {
              used[res.charAt(res.length()-1) - 'a'] = false;
              res.deleteCharAt(res.length()-1);
          }
          res.append(c);
          used[c-'a'] = true;
      }
      
      return res.toString();
  }
}