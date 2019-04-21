class Solution {
  public String longestCommonPrefix(String[] strs) {
      if (strs == null || strs.length == 0) return "";
      String ans = strs[0];
      
      for (String str: strs) {
          while (str.indexOf(ans) != 0) {
              ans = ans.substring(0, ans.length() - 1);
          }
      }
      return ans;
  }
}