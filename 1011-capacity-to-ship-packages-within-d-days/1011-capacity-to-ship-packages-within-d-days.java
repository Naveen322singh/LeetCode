class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int max_sum=0;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max_sum+=weights[i];
            maxi=Math.max(maxi,weights[i]);
        }
        int low=maxi;
        int high=max_sum;
        while(low<=high){
            int mid=(low+high)/2;
            int calculate_days=days_needed(weights,mid);
            if(calculate_days<=days){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public int days_needed(int []weights,int capacity){
        int load=0;
        int days=1;
        for(int i=0;i<weights.length;i++){
            if(load+weights[i]<=capacity){
                
                load+=weights[i];
            }
            else{
                days++;
                load=weights[i];
            }
        }
        return days;
    }
}