class Solution {
  public void reverseWords(char[] s) {
      if (s == null || s.length == 0) {
          return;
      }
      
      reverseHelper(s, 0, s.length - 1);
      int prevSpace = 0;
      
      for (int i = 0; i < s.length; i++) {
          if (i == s.length - 1) {
                 reverseHelper(s, prevSpace, s.length - 1);
          } else {
              if (s[i] == ' ') {
                  reverseHelper(s, prevSpace, i - 1);
                  prevSpace = i + 1;
              }
          }
      }
  }
  
  private void reverseHelper(char[] str, int left, int right) {
      while (left < right) {
          char tmp = str[left];
          str[left] = str[right];
          str[right] = tmp;
          left++;
          right--;
      }
  }
}