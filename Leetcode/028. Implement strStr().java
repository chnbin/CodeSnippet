class Solution {
  public int strStr(String haystack, String needle) {
      if (needle == null || needle.length() == 0) { return 0; }
      if (haystack.length() < needle.length()) { return -1; }
      int pos = 0;
      int len = needle.length();
      
      for (int i = 0; i < haystack.length(); i++) {
          if (haystack.charAt(i) == needle.charAt(0)) {
              pos = 1;
              for (int j = 1; j < len; j++) {
                  if ((i+j) < haystack.length()) {
                      if (haystack.charAt(i+j) == needle.charAt(j)) {
                          pos++;
                      }
                  }
              }
              if (pos == len) { return i; }
          }
      }
      return -1;
  }
}