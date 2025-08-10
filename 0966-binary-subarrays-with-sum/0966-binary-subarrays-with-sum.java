class Solution {
    public int numSubarraysWithSum(int[] arr, int goal) {
        int n = arr.length;
        int count = 0;

        int left = 0;    // main window start
        int sum = 0;
        int prefixZeros = 0; // count of leading zeros in window

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            // shrink from left if sum > goal
            while (left < right && sum > goal) {
                sum -= arr[left];
                left++;
                prefixZeros = 0; // reset zero count
            }

            // count trailing zeros at left when sum == goal
            while (left < right && arr[left] == 0 && sum == goal) {
                prefixZeros++;
                left++;
            }

            // if sum == goal, add count of subarrays ending here
            if (sum == goal) {
                count += 1 + prefixZeros;
            }
        }
        return count;
    }
}