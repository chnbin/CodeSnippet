class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) { return null; }
        List<Integer> list = getListFromNodes(head);
        
        return buildBST(list, 0, list.size() - 1);
    }
    
    private List<Integer> getListFromNodes(ListNode node) {
        List<Integer> res = new ArrayList<>();
        
        while (node != null) {
            res.add(node.val);
            node = node.next;
        }
        
        return res;
    }
    
    private TreeNode buildBST(List<Integer> list, int start, int end) {
        if (start > end) { return null; }
        
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildBST(list, start, mid - 1);
        root.right = buildBST(list, mid + 1, end);
        return root;
    }
}
