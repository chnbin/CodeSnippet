class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      // 建立root -> p與root -> q的路徑。
      // 然後比較路徑，一旦兩個點的值不同，則前一個點就是共同祖先。
      // 如果比較完兩條路徑都是相同的，則將短的路徑最後一點回傳。
      List<TreeNode> pPath = new ArrayList<>();
      List<TreeNode> qPath = new ArrayList<>();

      buildPath(pPath, new ArrayList<>(), root, p);
      buildPath(qPath, new ArrayList<>(), root, q);
      
      int len = Math.min(pPath.size(), qPath.size());
      
      for (int i = 0; i < len; i++) {
          if (pPath.get(i).val != qPath.get(i).val) {
              return pPath.get(i-1);
          }
      }
      
      return (pPath.size() < qPath.size()) ? pPath.get(pPath.size()-1) : qPath.get(qPath.size()-1);
  }
  
  private void buildPath(List<TreeNode> result,List<TreeNode> path, TreeNode node, TreeNode target) {
      if (node == null) { return; }
      if (node.val == target.val) {
          path.add(node);
          for (int i = 0; i < path.size(); i++) {
              result.add(path.get(i));
          }
      }
      
      path.add(node);
      buildPath(result, path, node.left, target);
      path.remove(path.size() - 1);
      
      path.add(node);
      buildPath(result, path, node.right, target);
      path.remove(path.size() - 1);
  }
}