class Solution {
    public int longestOnes(int[] arr, int k) {
        int left=0;
        int right=0;
        int zeroes=0;
        int length=0;

        while (right<arr.length){
            if (arr[right]==0){
                zeroes++;
            }
            while (zeroes>k){
                if (arr[left]==0){
                    zeroes--;

                }
                left++;
            }
            length=Math.max(length,right-left+1);
            right++;
        }
        return length;
    }
}