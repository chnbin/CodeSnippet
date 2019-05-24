class Solution {
  public String toGoatLatin(String S) {
      String vowels = "aeiouAEIOU";
      StringBuilder res = new StringBuilder();
      String lastWord = "a";

      for (String str: S.split(" ")) {
          String newWord = "";
          if (vowels.contains(str.charAt(0) + "")) {
              str += "ma";
          } else {
              str = str.substring(1, str.length()) + str.charAt(0) + "ma";
          }
          str += lastWord;
          lastWord += "a";
          res.append(str + " ");
      }
      return res.toString().substring(0, res.length() - 1);
  }
}