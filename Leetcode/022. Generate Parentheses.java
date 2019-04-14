import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> generateParenthesis(int n) {
      List<String> ans = new ArrayList<>();
      if (n == 0) {
          return ans;
      }
      generateParenthesisHelp(n, n, "", ans, 2 * n);
      return ans;
  }
  
  public void generateParenthesisHelp(int l, int r, String tmpAns, List<String> ans, int n) {
      if (tmpAns.length() == n) {
          ans.add(tmpAns);
      } else {
          if (l > 0) {
              generateParenthesisHelp(l - 1, r, tmpAns + "(", ans, n);
          }
          if (r > l) {
              generateParenthesisHelp(l, r - 1, tmpAns + ")", ans, n);
          }
      }
      
  }
}