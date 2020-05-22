class Solution {
  public String licenseKeyFormatting(String S, int K) {
      int indexOfFirstDash = S.indexOf("-");
      if (K - indexOfFirstDash > 0) {
          for (int i = 0; i < K - indexOfFirstDash; i++) {
              S = "#" + S;
          }
      }
      
      String license = S.replace("-", "");
      String res = "";
      
      int pos = 1;
      for (char c: license.toCharArray()) {
              res = res + Character.toUpperCase(c);
              if ((pos) % K == 0 && pos != license.length()) {
                  res += "-";
              }
          pos++;
      }

      return res.replace("#", "");
  }
}
