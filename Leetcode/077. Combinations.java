import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> ans = new ArrayList<List<Integer>>();
      List<Integer> currAns = new ArrayList<Integer>();
      combineHelper(n, k, 1, n + 1, ans, currAns);
      return ans;
  }
  
  public void combineHelper(int n, int k, int start, int end,
                            List<List<Integer>> ans, List<Integer> currAns) {
      if (currAns.size() == k) {
          List<Integer> tmp = new ArrayList<Integer>();
          for(int num: currAns) {
              tmp.add(num);
          }
          ans.add(tmp);
      } else {
          for(int i = start; i < end; i++) {
              currAns.add(i);
              combineHelper(n, k, i + 1, end, ans, currAns);
              currAns.remove(currAns.size() - 1);
          }
      }
  }
}