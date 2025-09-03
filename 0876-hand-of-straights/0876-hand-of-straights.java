import java.util.*;

public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int key : countMap.keySet()) {
            minHeap.offer(key);
        }
        
        while (!minHeap.isEmpty()) {
            int first = minHeap.peek();
            for (int i = first; i < first + groupSize; i++) {
                if (!countMap.containsKey(i) || countMap.get(i) == 0) {
                    return false;
                }
                countMap.put(i, countMap.get(i) - 1);
                if (countMap.get(i) == 0) {
                    if (minHeap.peek() != i) {
                        return false;
                    }
                    minHeap.poll();
                }
            }
        }
        
        return true;
    }
}