import java.util.Arrays;

class Solution {
  public int countCharacters(String[] words, String chars) {
      int res = 0;
      
      int[] charCnt = new int[26];
      
      for (char c: chars.toCharArray()) {
          charCnt[c - 'a']++;
      }
      
      for (String word: words) {
          int[] tmp = Arrays.copyOf(charCnt, charCnt.length);
          if (isGood(word, tmp)) {
              res += (word.length());
          }
      }
      return res;
  }
      
  private boolean isGood(String str, int[] charCnt) {
      boolean res = true;
      
      for (char c: str.toCharArray()) {
          if (charCnt[c - 'a'] == 0) {
              return false;
          } else {
              charCnt[c - 'a']--;
          }
      }
      return res;
  }
}