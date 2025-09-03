import java.util.PriorityQueue;

class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        
        // Add initial elements to the heap
        for (int i=0;i<nums.length;i++) {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        // If heap has less than k elements, just add the value
        if (minHeap.size() < k) {
            minHeap.add(val);
        } 
        // If heap has k elements and new value is larger than the smallest in heap
        else if (val > minHeap.peek()) {
            minHeap.poll();    // Remove the smallest element
            minHeap.offer(val); // Add the new larger element
        }
        // The top of minHeap is always the kth largest element
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */