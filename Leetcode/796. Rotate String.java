class Solution796 {
  public boolean rotateString(String A, String B) {
      if (A.length() != B.length()) { return false; }
      return A.concat(A).contains(B);
  }
}