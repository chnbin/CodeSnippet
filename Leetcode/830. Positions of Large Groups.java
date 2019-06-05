import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> largeGroupPositions(String S) {
      List<List<Integer>> res = new ArrayList<>();
      if (S == null || S.length() == 0) { return res; }
      
      int end = 0;
      int pos = 0;
      
      while (end < S.length()) {
          char c = S.charAt(end);
          
          if (c != S.charAt(pos)) {
              if (end - pos >= 3) {
                  List<Integer> localRes = new ArrayList<>();
                  localRes.add(pos);
                  localRes.add(end-1);
                  res.add(localRes);
              }
              pos = end;
          }
          end++;
      }
  
      if (end - pos >= 3) {
          List<Integer> localRes = new ArrayList<>();
          localRes.add(pos);
          localRes.add(end-1);
          res.add(localRes);
      }
      return res;
  }
}