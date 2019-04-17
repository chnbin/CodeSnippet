import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> getRow(int rowIndex) {
      List<Integer> ans = new ArrayList<Integer>();
      ans.add(1);
      int[] currLevel = {1};
      
      for (int i = 1; i <= rowIndex; i++) {
          int[] tmpLevel = new int[currLevel.length+1];
          for (int j = 0; j < tmpLevel.length; j++) {
              if (j == 0) {
                  tmpLevel[j] = currLevel[j];
              } else if (j == tmpLevel.length - 1) {
                  tmpLevel[j] = currLevel[currLevel.length-1];
              } else {
                  tmpLevel[j] = currLevel[j] + currLevel[j-1];
              }
          }
          
          currLevel = tmpLevel;
          if (i == rowIndex) {
              ans.clear();
              for (int num: tmpLevel) { ans.add(num); }
              
          }
      }
      return ans;
  }
}