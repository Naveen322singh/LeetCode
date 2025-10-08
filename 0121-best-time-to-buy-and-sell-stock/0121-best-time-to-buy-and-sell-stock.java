class Solution {
    public int maxProfit(int[] nums) {
        int maxProfit=Integer.MIN_VALUE;
        int minPrice=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            minPrice=Math.min(minPrice,nums[i]);
            maxProfit=Math.max(maxProfit,nums[i]-minPrice);
        }
        return maxProfit;
        
    }
}