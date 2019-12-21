class Solution {
  public List<TreeNode> generateTrees(int n) {
      if (n == 0) { return new ArrayList<>(); }
      return generateTreesHelper(1, n);
  }
  
  private List<TreeNode> generateTreesHelper(int start, int end) {
      List<TreeNode> res = new ArrayList<>();
      
      if (start > end) {
          res.add(null);
          return res;
      }
      
      for (int i = start; i <= end; i++) {
          List<TreeNode> left = generateTreesHelper(start, i - 1);
          List<TreeNode> right = generateTreesHelper(i + 1, end);
          
          for (TreeNode l: left) {
              for (TreeNode r: right) {
                  TreeNode root = new TreeNode(i);
                  root.left = l;
                  root.right = r;
                  res.add(root);
              }
          }
      }
      return res;
  }
}