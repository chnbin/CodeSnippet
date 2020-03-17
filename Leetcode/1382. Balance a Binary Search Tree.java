class Solution {
  public TreeNode balanceBST(TreeNode root) {
      List<Integer> sortedTree = new ArrayList<>();
      inOrder(root, sortedTree);
      return buildTree(sortedTree, 0, sortedTree.size() - 1);
  }
  
  private void inOrder(TreeNode node, List<Integer> list) {
      if (node == null) { return; }
      inOrder(node.left, list);
      list.add(node.val);
      inOrder(node.right, list);
  }
  
  private TreeNode buildTree(List<Integer> list, int left, int end) {
      if (left > end) { return null; }
      int mid = (left + end) / 2;
      TreeNode node = new TreeNode(list.get(mid));
      node.left = buildTree(list, left, mid - 1);
      node.right = buildTree(list, mid + 1, end);
      return node;
  }
}