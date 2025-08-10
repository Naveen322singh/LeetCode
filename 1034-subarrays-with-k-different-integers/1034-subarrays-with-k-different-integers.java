class Solution {
    public int subarraysWithKDistinct(int[] arr, int k) {
        return atMostK(arr, k) - atMostK(arr, k - 1);
        
    }
    private int atMostK(int[] arr, int k) {
        int l = 0;
        int r = 0;
        int n = arr.length;
        int count = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        while (r < n) {
            mpp.put(arr[r], mpp.getOrDefault(arr[r], 0) + 1);

            while (mpp.size() > k) {
                mpp.put(arr[l], mpp.get(arr[l]) - 1);
                if (mpp.get(arr[l]) == 0) {
                    mpp.remove(arr[l]);
                }
                l++;
            }

            count += r - l + 1;
            r++;
        }
        return count;
    }
}
