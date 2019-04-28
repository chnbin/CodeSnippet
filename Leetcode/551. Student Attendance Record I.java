class Solution {
  public boolean checkRecord(String s) {
      int count = 0;
      for (char c: s.toCharArray()) {
          if (c == 'A') { count++; }
      }
      return (count <= 1) && !s.contains("LLL");
  }
}