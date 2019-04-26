import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null) { return res; }
      boolean zigzag = false;
      LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
      queue.offer(root);
      
      while (!queue.isEmpty()) {
          LinkedList<Integer> level = new LinkedList<Integer>();
          int size = queue.size();
          
          for (int i = 0; i < size; i++) {
              TreeNode curr = queue.poll();
              if (zigzag) {
                  level.add(0, curr.val);
              } else {
                  level.add(curr.val);
              }
              if (curr.left != null) { queue.offer(curr.left); }
              if (curr.right != null) { queue.offer(curr.right); }
          }
          res.add(level);
          zigzag ^= true;
      }
      return res;
  }
}