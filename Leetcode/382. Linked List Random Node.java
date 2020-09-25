/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // Follow-up: 水塘抽樣
    Random r;
    ListNode head;
    int length = 0;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        r = new Random();
        
        this.head = head;
        ListNode curr = head;
        
        while (curr != null) {
            length++;
            curr = curr.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int n = r.nextInt(this.length);
        ListNode curr = this.head;
        
        while (n > 0) {
            curr = curr.next;
            n--;
        }
        
        return curr.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
