/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    String res = "";
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) { return ""; }
        String curr = ""; // String.valueOf((char)(root.val + (int)'a'));
        helper(root, curr);
        return res;
    }
    
    private void helper(TreeNode node, String curr) {
        if (node == null) { return; }
        if (node.left == null && node.right == null) {
            curr = String.valueOf((char)(node.val + (int)'a')) + curr;
            // System.out.println(curr);
            if (res.equals("")) {
                res = curr;
            } else {
                if (res.compareTo(curr) > 0) {
                    res = curr;
                }
            }
            return;
        }
        
        curr = String.valueOf((char)(node.val + (int)'a')) + curr;
        helper(node.left, curr);
        helper(node.right, curr);
    }
}
