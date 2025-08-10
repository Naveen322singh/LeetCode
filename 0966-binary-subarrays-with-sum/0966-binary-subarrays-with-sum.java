class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return binarySubarrayCount(nums, goal) - binarySubarrayCount(nums, goal - 1);
    }
    
    private int binarySubarrayCount(int[] arr, int goal) {
        if (goal < 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int count = 0;
        int sum = 0;
        int n = arr.length;
        while (r < n) {
            sum += arr[r];
            while (sum > goal) {
                sum -= arr[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}