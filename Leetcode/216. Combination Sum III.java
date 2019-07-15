import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> combinationSum3(int k, int n) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      List<Integer> currAns = new ArrayList<>();
      combSumHelper(k, 1, 9, n, res, currAns);
      return res;
  }
  
  private void combSumHelper(int k, int start, int end, int n, List<List<Integer>> res, List<Integer> currAns) {
      if (n == 0 && currAns.size() == k) {
          List<Integer> ans = new ArrayList<>();
          for (int i = 0; i < currAns.size(); i++) {
              ans.add(currAns.get(i));
          }
          res.add(ans);
      } else {
          for (int i = start; i <= end; i++) {
              if (0 <= i && i <= 9) {
                  if (n >= i) {
                      n -= i;
                      currAns.add(i);
                      combSumHelper(k, i+1, end, n, res, currAns);
                      currAns.remove(currAns.size()-1);
                      n += i;
                  }
              }
          }
      }
  }
}