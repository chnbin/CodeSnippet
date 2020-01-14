class Solution {
  private int maxUni = 0;
  public int longestUnivaluePath(TreeNode root) {
      if (root == null) { return 0; }
      longestUnivaluePathHelper(root);
      return maxUni;
  }
  
  private int[] longestUnivaluePathHelper(TreeNode node) {
      if (node == null) { 
          int[] n = new int[2];
          n[0] = 0;
          n[1] = -1;
          return n;
      }
      
      int[] left = longestUnivaluePathHelper(node.left);
      int[] right = longestUnivaluePathHelper(node.right);
      
      int value = node.val;
      int lPath = 0;
      if (left[1] != -1 && left[0] == value) {
          lPath = left[1];
      }
      
      int rPath = 0;
      if (right[1] != -1 && right[0] == value) {
          rPath = right[1];
      }
      
      maxUni = Math.max(maxUni, lPath + rPath);
      
      int[] res = new int[2];
      res[0] = value;
      res[1] = 1 + Math.max(lPath, rPath);
      return res;
  }
}