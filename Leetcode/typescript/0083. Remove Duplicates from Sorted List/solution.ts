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

function deleteDuplicates(head: ListNode | null): ListNode | null {
    let node: ListNode = new ListNode(-1);
    node.next = head;
    
    while (node && node.next) {
        while (node && node.next && node.val === node.next.val) {
            node.next = node.next.next;
        }
        
        if (node && node.next) {
            node = node.next;
        }
    }
    
    return head;
};
