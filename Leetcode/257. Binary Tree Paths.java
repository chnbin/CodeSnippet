import java.util.ArrayList;
import java.util.List;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

class Solution {
   public List<String> binaryTreePaths(TreeNode root) {
       if (root == null) { return new ArrayList<String>(); }
       List<String> ans = new ArrayList<String>();
       binaryTreePathsHelper(root, ans, "");
       return ans;
   }
   
   private void binaryTreePathsHelper(TreeNode node, List<String> ans, String path) {
       if (node != null) {
           if (node.left == null && node.right == null) {
               path += Integer.toString(node.val);
               ans.add(path);
               return;
           }
           if (node.left != null) {
               binaryTreePathsHelper(node.left, ans, path + node.val + "->");
           }
           if (node.right != null) {
               binaryTreePathsHelper(node.right, ans, path + node.val + "->");
           }
       }
   }
}