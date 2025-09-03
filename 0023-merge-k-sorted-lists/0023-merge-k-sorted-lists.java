import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // Create a min-heap (priority queue) that compares ListNode values
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the head of each non-empty linked list to the heap using simple for loop
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.add(lists[i]);
            }
        }
        
        // Create a dummy node to simplify the merging process
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Process the heap until it's empty
        while (!minHeap.isEmpty()) {
            // Get the smallest node from the heap
            ListNode smallest = minHeap.poll();
            
            // Add it to the result list
            current.next = smallest;
            current = current.next;
            
            // If there's a next node in the same list, add it to the heap
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }
        
        return dummy.next;
    }
}