class Solution {
  public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
      if (root1 == null || root2 == null) { return false; }
      Set<Integer> set = new HashSet<>();
      collectTreeElement(root1, set);
      return toFindSum(root2, set, target);
  }
  
  private void collectTreeElement(TreeNode node, Set<Integer> set) {
      if (node == null) { return; }
      set.add(node.val);
      collectTreeElement(node.left, set);
      collectTreeElement(node.right, set);
  }
  
  private boolean toFindSum(TreeNode node, Set<Integer> set, int target) {
      if (node == null) { return false; }
      
      if (set.contains(target - node.val)) {
          return true;
      }
      
      return toFindSum(node.left, set, target) || toFindSum(node.right, set, target);
  }
}