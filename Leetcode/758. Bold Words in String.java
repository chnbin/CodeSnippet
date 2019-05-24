class Solution {
  public String boldWords(String[] words, String S) {
      int len = S.length();
      boolean[] boldLocation = new boolean[len];
      
      for (String word: words) {
          int wordLen = word.length();
          for (int i = 0; i <= len - wordLen; i++) {
              if (S.charAt(i) == word.charAt(0) && S.substring(i, i + wordLen).equals(word)) {
                  for (int j = i; j < i + wordLen; j++) {
                      boldLocation[j] = true;
                  }
              }
          }
      }
      // for (boolean b: boldLocation) { System.out.println(b); }
      String res = "";
      for (int i = 0; i < len; i++) {
          if (!boldLocation[i]) {
              res += ""+S.charAt(i);
          } else {
              if ((i == 0 || !boldLocation[i-1])) {
                  res += "<b>";
              }
              res += ""+S.charAt(i);
              if ((i == len - 1 || !boldLocation[i+1])) {
                  res += "</b>";
              }   
          }
      }
      return res;
  }
}