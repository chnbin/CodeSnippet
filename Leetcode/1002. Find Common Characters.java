import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> commonChars(String[] A) {
      List<String> res = new ArrayList<String>();
      if (A == null || A.length == 0) { return res; }
      int[] chars = new int[26];
      
      for (char c: A[0].toCharArray()) {
          chars[c-'a']++;
      }
      
      for (int i = 1; i < A.length; i++) {
          int[] tmp = new int[26];
          for (char c: A[i].toCharArray()) {
              tmp[c-'a']++;
          }
          
          for (int j = 0; j < 26; j++) {
              chars[j] = Math.min(chars[j], tmp[j]);
          }
      }
      
      for (int i = 0; i < 26; i++) {
          for (int j = 0;  j < chars[i]; j++) {
              res.add(String.valueOf((char)(i+'a')));
          }
      }
      return res;
  }
}