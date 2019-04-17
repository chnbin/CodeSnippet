import java.util.ArrayList;
import java.util.List;

class Solution1 {
  public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> ans = new ArrayList<List<Integer>>();
      if (numRows == 0) { return ans; }
      int[] currlevel = {1};
      ArrayList<Integer> level = new ArrayList<Integer>();
      
      for (int num: currlevel) { level.add(num);}
      ans.add(new ArrayList<>(level));
      
      for (int i = 1; i < numRows; i++) {
          int[] tmpLevel = new int[currlevel.length+1];
          
          for (int j = 0; j < tmpLevel.length; j++) {
              if (j == 0) {
                  tmpLevel[j] = currlevel[j];
              } else if (j == tmpLevel.length - 1) {
                  tmpLevel[j] = currlevel[currlevel.length-1];
              } else {
                  tmpLevel[j] = currlevel[j] + currlevel[j-1];
              }
          }
          level.clear();
          for (int num: tmpLevel) { level.add(num);}
          ans.add(new ArrayList<>(level));
          currlevel = tmpLevel;
      }
      return ans;
  }
}