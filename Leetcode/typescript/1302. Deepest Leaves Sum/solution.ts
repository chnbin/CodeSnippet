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

function deepestLeavesSum(root: TreeNode | null): number {
    if (root === null) { return 0; }
    let res: number[] = new Array(2).fill(0);
    let level: number[] = new Array(2).fill(0);
    
    maxHeight(root, 0, level);
    deepestLeavesSumHelper(root, 0, level[0], res);
    
    return res[0];
};

function maxHeight(node: TreeNode, depth: number, level: number[]) {
    if (node.left === null && node.right === null) {
        level[0] = Math.max(level[0], depth);
        return;
    }
    
    if (node.left !== null) {
        maxHeight(node.left, depth + 1, level);
    }
    
    if (node.right !== null) {
        maxHeight(node.right, depth + 1, level);
    }
}

function deepestLeavesSumHelper(node: TreeNode, depth: number, level: number, res: number[]) {
    if (node.left === null && node.right === null && depth === level) {
        res[0] += node.val;
        return;
    }
    
    if (node.left !== null) {
        deepestLeavesSumHelper(node.left, depth + 1, level, res);
    }
    
    if (node.right !== null) {
        deepestLeavesSumHelper(node.right, depth + 1, level, res);
    }
}


