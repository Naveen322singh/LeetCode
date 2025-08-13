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
        int size=size_LL(head);
        int target=size-n+1;
        if(head==null){
            return null;
        }
        if(target==1){
            head=head.next;
            return head;
        }
        ListNode temp=head;
        int count=0;
       
        while(temp!=null&&temp.next!=null){
            count++;
            if(count==target-1){
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
        return head;
        
    }
    public int size_LL(ListNode head){
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
}