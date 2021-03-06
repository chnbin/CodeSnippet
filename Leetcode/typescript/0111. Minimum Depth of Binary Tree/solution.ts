/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function minDepth(root: TreeNode | null): number {
    if (root === null) { return 0; }
    let res: number[] = new Array(2).fill(Number.MAX_VALUE);
    
    helper(root, 1, res);
    
    return res[0];
};

function helper(node: TreeNode, level: number, res: number[]): void {
    if (node.left === null && node.right === null) {
        res[0] = Math.min(res[0], level);
        return;
    }
    
    if (node.left !== null) {
        helper(node.left, level + 1, res);
    }
    
    if (node.right !== null) {
        helper(node.right, level + 1, res);
    }
}
