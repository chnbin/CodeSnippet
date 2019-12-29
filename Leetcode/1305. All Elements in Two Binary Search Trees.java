class Solution {
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
      List<Integer> t1 = new ArrayList<>();
      List<Integer> t2 = new ArrayList<>();
      inOrder(root1, t1);
      inOrder(root2, t2);
      
      List<Integer> res = new ArrayList<>();
      int m = t1.size();
      int n = t2.size();
      
      for (int i = 0; i < m; i++) {
          res.add(t1.get(i));
      }
      
      for (int i = 0; i < n; i++) {
          res.add(t2.get(i));
      }
      
      Collections.sort(res);
      
      return res;
  }
  
  private void inOrder(TreeNode node, List<Integer> res) {
      if (node == null) { return; }
      inOrder(node.left, res);
      res.add(node.val);
      inOrder(node.right, res);
  }
}