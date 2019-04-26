import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> ans = new ArrayList<>();
      if (root == null) { return ans; }
      LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
      queue.offer(root);
      
      while (!queue.isEmpty()) {
          List<Integer> level = new ArrayList<Integer>();
          int len = queue.size();
          for (int i = 0; i < len; i++) {
              if (queue.peek().left != null) { queue.offer(queue.peek().left); }
              if (queue.peek().right != null) { queue.offer(queue.peek().right);}
              level.add(queue.poll().val);
          }
          ans.add(new ArrayList(level));
      }
      return ans;
  }
}