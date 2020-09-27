/**
 * Definition for a binary tree node.
 **/
 class TreeNode {
    val: number
    left: TreeNode | null
    right: TreeNode | null
    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
         this.val = (val===undefined ? 0 : val)
         this.left = (left===undefined ? null : left)
         this.right = (right===undefined ? null : right)
     }
 }
 

function maxDepth(root: TreeNode | null): number {
    if (root === null) { return 0; }
    
    let res: number[] = new Array(2).fill(0);
    helper(root, 1, res);
    return res[0];
};

function helperMaxDepth(node: TreeNode, level: number, res: number[]): void {
    if (node.left === null && node.right === null) {
        res[0] = Math.max(res[0], level);
        return;
    }
    
    if (node.left !== null) {
        helperMaxDepth(node.left, level + 1, res);
    }
    
    if (node.right !== null) {
        helperMaxDepth(node.right, level + 1, res);
    }
}
