class Solution {
  public String reverseOnlyLetters(String S) {
      int l = 0;
      int r = S.length() - 1;
      char[] s = S.toCharArray();
      
      while (l < r) {
          while (l < r && !Character.isLetter(s[l])) { l++; }
          while (l < r && !Character.isLetter(s[r])) { r--; }
          swap(s, l, r);
          l++;
          r--;
      }
      
      return new String(s);
  }
  
  public void swap(char[] str, int i, int j) {
      char tmp = str[i];
      str[i] = str[j];
      str[j] = tmp;
  }
}