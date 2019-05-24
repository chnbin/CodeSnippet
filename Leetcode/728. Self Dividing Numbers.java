import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> selfDividingNumbers(int left, int right) {
      List<Integer> res = new ArrayList<>();
      for (int i = left; i <= right; i++) {
          if (isSelfDividingNumbers(i)) {
              res.add(i);
          }
      }
      return res;
  }
  
  private boolean isSelfDividingNumbers(int n) {
      int m = n;
      while (n > 0) {
          int digit = n % 10;
          
          if (digit == 0) {
              return false;
          } else {
              if ((m % digit) != 0) {
                  return false;
              }
          }
          n /= 10;
      }
      return true;
  }
}