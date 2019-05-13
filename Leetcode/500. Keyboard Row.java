import java.util.ArrayList;
import java.util.List;

class Solution {
  public String[] findWords(String[] words) {
      if (words == null || words.length == 0) { return new String[0]; }
      final String keyRow1 = "qwertyuiop";
      final String keyRow2 = "asdfghjkl";
      final String keyRow3 = "zxcvbnm";
      List<String> res = new ArrayList<>();
      
      for (String word: words) {
          if (isInSameRow(keyRow1, word) || isInSameRow(keyRow2, word) || isInSameRow(keyRow3, word)) {
              res.add(word);
          }
      }
      return res.toArray(new String[res.size()]);
  }
  
  private boolean isInSameRow(String rowChars, String str) {
      for (int i = 0; i < str.length(); i++) {
          char c = Character.toLowerCase(str.charAt(i));
          if (rowChars.indexOf(c) == -1) {
              return false;
          }
      }
      return true;
  }
}