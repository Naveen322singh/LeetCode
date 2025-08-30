class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        int maxi=Integer.MIN_VALUE;
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,bloomDay[i]);
            mini=Math.min(mini,bloomDay[i]);
        }
        if((long)m*k>n){
            return -1;
        }
        int low=mini;
        int high=maxi;
        int min_days=Integer.MIN_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            int bouquets_made=bouquets(bloomDay,mid,k);
            if(bouquets_made>=m){
                min_days=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return min_days;
    }
    public int bouquets(int [] bloomDay,int bloom_Day,int adjacent_flowers){
        int flowers_bloomed=0;
        int bouquets_made=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=bloom_Day){
                flowers_bloomed++;
                if(flowers_bloomed==adjacent_flowers){
                    bouquets_made++;
                    flowers_bloomed=0;
                }
            }
            else{
                flowers_bloomed=0;
            }
        }
        return bouquets_made;
    }
}