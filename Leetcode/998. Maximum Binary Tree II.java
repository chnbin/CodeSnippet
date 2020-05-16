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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        return insertIntoMaxTreeHelper(root, val);
    }
    
    private TreeNode insertIntoMaxTreeHelper(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        
        if (val > node.val) {
            TreeNode n = new TreeNode(val);
            n.left = node;
            return n;
        }
        
        node.right = insertIntoMaxTreeHelper(node.right, val);
        return node;
    }
}
