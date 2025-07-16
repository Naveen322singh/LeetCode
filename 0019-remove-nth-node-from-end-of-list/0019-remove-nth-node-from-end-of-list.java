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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length_LL=lengthofLL(head);
        int target=length_LL-n+1;
        //we have to remove the target node
        if (head==null){
            return head;
        }
        if (target==1){
            head=head.next;
            return head;
        }
        int count=0;
        ListNode temp=head;
        ListNode prev=null;
        while (temp!=null){
            count++;
            if (count==target){
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }
    public int lengthofLL(ListNode head){
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
            
        }
        return count;
    }
}