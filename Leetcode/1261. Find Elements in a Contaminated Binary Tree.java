class FindElements {
  TreeNode tree;
  Set<Integer> treeValue;
  public FindElements(TreeNode root) {
      treeValue = new HashSet<>();
      recoverTree(root, 0, treeValue);
      tree = root;
  }
  
  public boolean find(int target) {
      return treeValue.contains(target);
  }
  
  private void recoverTree(TreeNode node, int value, Set<Integer> treeValue) {
      if (node == null) { return; }
      treeValue.add(value);
      if (node.left != null) { recoverTree(node.left, 2 * value + 1, treeValue); }
      if (node.right != null) { recoverTree(node.right, 2 * value + 2, treeValue); }
  }
}