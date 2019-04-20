class Solution {
  public int lengthOfLastWord(String s) {
      if (s == null || s.length() == 0) { return 0; }
      int lengthOfLastWord = 0;
      
      for(int i = s.length() - 1; i >= 0; i--) {
          if (s.charAt(i) != ' ') {
              lengthOfLastWord++;
          } else if (lengthOfLastWord == 0) {
              continue;
          } else {
              break;
          }
      }
      
      return lengthOfLastWord;
  }
}