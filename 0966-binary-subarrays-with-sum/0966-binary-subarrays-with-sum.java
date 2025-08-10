class Solution {
    public int numSubarraysWithSum(int[] arr, int sum_k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // To handle the case when the sum from index 0 to i equals sum_k
        int currentSum = 0;
        int count = 0;

        for (int num : arr) {
            currentSum += num;
            // Check if (currentSum - sum_k) exists in the map
            if (prefixSumCount.containsKey(currentSum - sum_k)) {
                count += prefixSumCount.get(currentSum - sum_k);
            }
            // Update the map with the current prefix sum
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}