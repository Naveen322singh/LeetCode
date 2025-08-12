class Solution {
    public int maxProfit(int[] nums) {
        int maxpro=0;
        int minprice=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            minprice=Math.min(minprice,nums[i]);
            maxpro=Math.max(maxpro,nums[i]-minprice);
        }
        return maxpro;
        
    }
}