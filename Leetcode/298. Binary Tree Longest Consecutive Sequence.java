class Solution {
    int max;
    public int longestConsecutive(TreeNode root) {
        if (root == null) { return 0; }
        helper(root, 0, root.val + 1);
        return max;
    }
    
    private void helper(TreeNode node, int curr, int target) {
        if (node == null) { return; }
        
        if (node.val == target) {
            curr++;
        } else {
            target = node.val;
            curr = 1;
        }
        max = Math.max(max, curr);
        helper(node.left, curr, target + 1);
        helper(node.right, curr, target + 1);
    }
}