import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> generatePossibleNextMoves(String s) {
      List<String> res = new ArrayList<>();
      
      for (int i = 1; i < s.length(); i++) {
          char[] str = s.toCharArray();
          
          if (str[i] == '+' && str[i-1] == '+') {
              str[i] = '-';
              str[i-1] = '-';
              res.add(new String(str));
          }
      }
      
      return res;
  }
}