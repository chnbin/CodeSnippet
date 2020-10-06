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

function insertIntoBST(root: TreeNode | null, val: number): TreeNode | null {
    if (root === null) { return new TreeNode(val); }
    let node: TreeNode = root;
    
    while (node !== null) {
        if (val < node.val) {
            if (node.left === null) {
                node.left = new TreeNode(val);
                break;
            }
            node = node.left;
        } else {
            if (node.right === null) {
                node.right = new TreeNode(val);
                break;
            }
            node = node.right;
        }
    }
    
    return root;
};

