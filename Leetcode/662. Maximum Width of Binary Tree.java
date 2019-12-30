class Solution {
  public int widthOfBinaryTree(TreeNode root) {
      if (root == null) { return 0; }
      int res = 1;
      
      Queue<NodeInfo> q = new LinkedList<>();
      q.offer(new NodeInfo(root, 1));
      
      while (!q.isEmpty()) {
          int size = q.size();
          int left = 0;
          int right = 0;
          
          for (int i = 0; i < size; i++) {
              NodeInfo node = q.poll();
              int level = node.level;
              if (i == 0) { left = level; }
              if (i == size - 1) { right = level; }
              if (node.node.left != null) {
                  q.offer(new NodeInfo(node.node.left, 2*level));
              }
              if (node.node.right != null) {
                  q.offer(new NodeInfo(node.node.right, 2*level + 1));
              }
          }
          res = Math.max(res, right - left + 1);
      }
      
      return res;
  }
}

class NodeInfo {
  TreeNode node;
  int level;
  public NodeInfo(TreeNode node, int level) {
      this.node = node;
      this.level = level;
  }
}