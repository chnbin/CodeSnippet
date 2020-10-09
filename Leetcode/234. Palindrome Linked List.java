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
    public boolean isPalindrome(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode dummy = head;
        
        while (dummy != null) {
            stack.push(dummy.val);
            dummy = dummy.next;
        }
        
        dummy = head;
        
        while (dummy != null) {
            if (dummy.val == stack.peek()) {
                stack.pop();
                dummy = dummy.next;
            } else {
                return false;
            }
        }
        
        
        return true;
    }
}
