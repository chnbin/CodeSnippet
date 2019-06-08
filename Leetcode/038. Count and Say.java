class Solution {
  public String countAndSay(int n) {
      if (n == 1) { return "1"; }
      String res = "1";
      
      for (int i = 2; i <= n; i++) {
          int pos = 0;
          StringBuilder tmpAns = new StringBuilder();
          
          while (pos < res.length()) {
              char curr = res.charAt(pos);
              int count = 0;
              while (pos < res.length() && curr == res.charAt(pos)) {
                  pos++;
                  count++;
              }
              tmpAns.append(count);
              tmpAns.append(curr);
          }

          res = tmpAns.toString();
      }
      return res;
  }
}