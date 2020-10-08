/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function removeElements(head: ListNode | null, val: number): ListNode | null {
    if (!head) { return head; }
    let node: ListNode = new ListNode(-1);
    let dummy: ListNode = new ListNode(-1);
    dummy = head;
    node.next = head;
    dummy = node;
    
    while(node.next) {
        while (node.next && node.next.val === val) {
            node.next = node.next.next;
        }
        if (node && node.next) {
            node = node.next;
        }
    }
    
    return dummy.next;
};

