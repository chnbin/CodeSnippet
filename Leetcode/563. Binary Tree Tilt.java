class Solution {
    int res = 0;
    
    public int findTilt(TreeNode root) {
        if (root == null) { return 0; }
        findTiltHelper(root);
        return res;
    }
    
    private int findTiltHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftSum = findTiltHelper(node.left);
        int rightSum = findTiltHelper(node.right);
        res += Math.abs(leftSum - rightSum);
        return node.val + leftSum + rightSum;
    }
}
