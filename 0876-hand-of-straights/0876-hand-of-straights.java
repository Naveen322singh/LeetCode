import java.util.*;

public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            countMap.put(hand[i], countMap.getOrDefault(hand[i], 0) + 1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> keys = countMap.keySet();
        for (Iterator<Integer> it = keys.iterator(); it.hasNext(); ) {
            int key = it.next();
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