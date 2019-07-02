import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<Integer> pathInZigZagTree(int label) {
      LinkedList<Integer> res = new LinkedList<>();

      res.add(label);
      int parent = label;
      
      while (parent > 1) {
          int node = (int)(Math.log(parent)/Math.log(2));
          int depth = node + 1;
          int offset = (int)Math.pow(2.0, depth) - 1 - parent;
          parent = (int)Math.pow(2.0, node-1) + (int)(offset/2);
          res.addFirst(parent);
      }
      return res;
  }
}