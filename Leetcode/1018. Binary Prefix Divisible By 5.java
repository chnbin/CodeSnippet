import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Boolean> prefixesDivBy5(int[] A) {
      List<Boolean> res = new ArrayList<Boolean>();
      int prefix = 0;
      
      for (int num: A) {
          prefix = ((prefix*2 + num) % 5);
          res.add((prefix == 0));
          
      }
      return res;
  }
}