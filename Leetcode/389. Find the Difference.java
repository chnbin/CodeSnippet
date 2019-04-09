class Solution {
  public char findTheDifference(String s, String t) {
      int ans = 0;
      
      // You can convert a character to ASCII numberic value
      // by casting char to int
      for (int i = 0; i < s.length(); i++) {
          ans ^= (int)s.charAt(i);
      }
      
      for (int j = 0; j < t.length(); j++) {
          ans ^= (int)t.charAt(j);
      }
      
      return (char)ans;
  }
}