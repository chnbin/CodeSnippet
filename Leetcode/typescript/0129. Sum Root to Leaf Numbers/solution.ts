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

function sumNumbers(root: TreeNode | null): number {
    if (root === null) { return 0; }
    let res: number[] = new Array(2).fill(0);
    sumNumbersHelper(root, 0, res);
    return res[0];
};

function sumNumbersHelper(node: TreeNode, sum: number, res: number[]): void {
    if (node.left === null && node.right === null) {
        res[0] += (sum * 10 + node.val);
        return;
    }
    
    if (node.left !== null) {
        sumNumbersHelper(node.left, sum * 10 + node.val, res);
    }

    if (node.right !== null) {
        sumNumbersHelper(node.right, sum * 10 + node.val, res);
    }
}
