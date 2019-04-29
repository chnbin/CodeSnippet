class Solution {
  public String toLowerCase(String str) {
      if (str == null || str.length() == 0) { return ""; }
      StringBuilder res = new StringBuilder();
      
      for (char c: str.toCharArray()) {
          if ('A' <= c && c <= 'Z') {
              res.append((char)(c + 32));
          } else {
              res.append(c);
          }
      }
      return res.toString();
  }
}