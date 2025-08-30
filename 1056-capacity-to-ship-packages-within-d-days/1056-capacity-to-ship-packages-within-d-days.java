class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int max_sum=0;
        int mini=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max_sum+=weights[i];
            mini=Math.max(mini,weights[i]);
        }
        int ans=-1;
        int low=mini;
        int high=max_sum;
        while(low<=high){
            int mid=(low+high)/2;
            int calculate_days=days_needed(weights,mid);
            if(calculate_days<=days){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int days_needed(int []weights,int capacity){
        int load=0;
        int days=1;
        for(int i=0;i<weights.length;i++){
            if(load+weights[i]>capacity){
                days++;
                load=weights[i];
            }
            else{
                load+=weights[i];
            }
        }
        return days;
    }
}