import java.util.HashSet;

class Solution {
  public int repeatedNTimes(int[] A) {
      HashSet<Integer> set = new HashSet<Integer>();
      
      for (int num: A) {
          if (set.contains(num)) {
              return num;
          }
          set.add(num);
      }
      return -1;
  }
}