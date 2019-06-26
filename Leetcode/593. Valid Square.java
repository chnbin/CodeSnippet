import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
      Set<Integer> set = new HashSet<>();
      set.add(getLineLength(p1[0], p1[1], p2[0], p2[1]));
      set.add(getLineLength(p1[0], p1[1], p3[0], p3[1]));
      set.add(getLineLength(p1[0], p1[1], p4[0], p4[1]));
      set.add(getLineLength(p2[0], p2[1], p3[0], p3[1]));
      set.add(getLineLength(p2[0], p2[1], p4[0], p4[1]));
      set.add(getLineLength(p3[0], p3[1], p4[0], p4[1]));
      
      return (set.size() == 2 && !set.contains(0));
  }
  
  private int getLineLength(int p1x, int p1y, int p2x, int p2y) {
      return (p2x-p1x)*(p2x-p1x) + (p2y-p1y)*(p2y-p1y);
  }
}