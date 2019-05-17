import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
      List<List<Integer>> res = new LinkedList<List<Integer>>();
      if (root == null) { return res; }
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.offer(root);
      
      while (!queue.isEmpty()) {
          int size = queue.size();
          List<Integer> level = new ArrayList<Integer>();
          
          for (int i = 0; i < size; i++) {
              TreeNode node = queue.poll();
              level.add(node.val);
              if (node.left != null) { queue.offer(node.left); }
              if (node.right != null) { queue.offer(node.right); }
          }
          res.add(0, level);
      }
      
      return res;
  }
  /**
   * Recusive version
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrderBottomRecusive(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (root == null) { return res; }
    helper(root, 1, res);
    return res;
  }
  private void helper(TreeNode node, int level, List<List<Integer>> res) {
    if (node == null) { return; }
    if (res.size() < level) {
        res.add(0, new ArrayList<Integer>());
    }
    res.get(res.size() - 1 - (level - 1)).add(node.val);
    helper(node.left, level + 1, res);
    helper(node.right, level + 1, res);
  }
}