import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean isHappy(int n) {
      Set<Integer> set = new HashSet<Integer>();
      
      while (set.contains(n) == false) {
          set.add(n);
          int sum = 0;
          while (n > 0) {
              int remain = n % 10;
              sum += (remain * remain);
              n /= 10;
          }

          if (sum == 1) { return true; }
          n = sum;

      }
      
      return false;
  }
}