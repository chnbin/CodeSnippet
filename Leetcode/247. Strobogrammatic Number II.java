class Solution {
  public List<String> findStrobogrammatic(int n) {
      List<String> res = new ArrayList<>();
      if (n % 2 == 0) {
          helper(n, "", res);
      } else {
          helper(n - 1, "0", res);
          helper(n - 1, "1", res);
          helper(n - 1, "8", res);
      }
      Collections.sort(res);
      return res;
  }
  
  private void helper(int n, String tmp, List<String> res) {
      if (n == 0) {
          if (tmp.charAt(0) == '0' && tmp.length() != 1) { return ;}
          res.add(tmp);
      } else {
          helper(n - 2, "0" + tmp + "0", res);
          helper(n - 2, "1" + tmp + "1", res);
          helper(n - 2, "6" + tmp + "9", res);
          helper(n - 2, "9" + tmp + "6", res);
          helper(n - 2, "8" + tmp + "8", res);
      }
  }
}