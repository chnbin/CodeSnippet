import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> grayCode(int n) {
      List<Integer> res = new ArrayList<Integer>();
      res.add(0);
      if (n == 0) { return res; }
      int base = 1;
      
      for (int i = 0; i < n; i++) {
          List<Integer> tmp = new ArrayList<Integer>();
          for (int j = res.size()-1; j >=0;j--) {
              tmp.add(res.get(j)+base);
          }
          
          for(int k = 0; k < tmp.size(); k++) {
              res.add(tmp.get(k));
          }
          base *= 2;
      }
      return res;
  }
}