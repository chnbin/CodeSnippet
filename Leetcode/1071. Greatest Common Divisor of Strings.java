class Solution {
  public String gcdOfStrings(String str1, String str2) {
      if (str1 == null || str2 == null) {
          return "";
      }
      
      if (str1.length() == 0 || str2.length() == 0) {
          return "";
      }
      
      if (str1.length() < str2.length()) {
          return gcdOfStrings(str2, str1);
      }
      
      if (str1.startsWith(str2)) {
          if (str1.length() == str2.length()) {
              return str1;
          } else {
              return gcdOfStrings(str2, str1.substring(str2.length()));   
          }
      } else {
          return "";
      }
  }
}