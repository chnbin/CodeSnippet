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

function sortedArrayToBST(nums: number[]): TreeNode | null {
    if (nums === null || nums.length === 0) {
        return null;
    }
    
    return createBSTNode(nums, 0, nums.length - 1);
};

function createBSTNode(nums: number[], start: number, end: number): TreeNode | null {
    if (start > end) {
        return null;
    }
    
    let idx:number = Math.floor((start + end) / 2);
    let root: TreeNode = new TreeNode(nums[idx]);
    root.left = createBSTNode(nums, start, idx - 1);
    root.right = createBSTNode(nums, idx + 1, end);
    
    return root;
}
