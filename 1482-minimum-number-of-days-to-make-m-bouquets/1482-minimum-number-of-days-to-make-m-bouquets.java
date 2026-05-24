class Solution {
    public int minDays(int[] bloomDay,int m,int k){
        if ((long) m * k > bloomDay.length) {
            return -1;
        }
        int maxi=Integer.MIN_VALUE;
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            maxi=Math.max(maxi,bloomDay[i]);
            mini=Math.min(mini,bloomDay[i]);
        }
        int start=mini;
        int end=maxi;
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(countBouquets(bloomDay,mid,k)>=m){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
    public int countBouquets(int[] bloomDay,int mid, int k){
        int countFlower=0;
        int countBouquets=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid) {
                countFlower++;
                if(countFlower==k) {
                    countBouquets++;
                    countFlower = 0;
                }
            }
            else {
                countFlower = 0;
            }
        }
        return countBouquets;
    }
}