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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        ListNode dummy = new ListNode(); // Dummy node to start the merged list
        ListNode mover = dummy; // Tail pointer to build the merged list

        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                mover.next = temp1;
                temp1 = temp1.next;
            } else {
                mover.next = temp2;
                temp2 = temp2.next;
            }
            mover = mover.next;
        }

        // Attach the remaining elements
        if (temp1 != null) {
            mover.next = temp1;
        } else {
            mover.next = temp2;
        }

        return dummy.next; // Skip the dummy node
        
    }
}